package ar.gob.dajudeco.poc.bfa.servicio;

import static org.springframework.http.HttpMethod.GET;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class BFA {

	private static final String HTTPS_URL_SELLAR = "https://tsa2.buenosaires.gob.ar/stamp";
	private static final String HTTP_URL_VALIDAR = "https://tsa2.buenosaires.gob.ar/verify/";
	
	private static HttpHeaders headers;
	static {
		headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "*/*");
	}

	public String verify(byte[] file) throws NoSuchAlgorithmException, IOException {
		MessageDigest shaDigest = MessageDigest.getInstance("SHA-256");
		String shaChecksum = getFileChecksum(shaDigest, file);
		return this.verify(shaChecksum);
	}

	public String verify(String hash) {
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> responseEntity = rest.exchange(HTTP_URL_VALIDAR + hash, GET, requestEntity, String.class);
		String body = responseEntity.getBody();
		return body;
	}

	public String sellar(byte[] file) throws IOException, NoSuchAlgorithmException {
		MessageDigest shaDigest = MessageDigest.getInstance("SHA-256");
		String shaChecksum = getFileChecksum(shaDigest, file);

		RestTemplate rest = new RestTemplate();

		HttpEntity<String> requestEntity = new HttpEntity<String>("{\"hashes\":[\"" + shaChecksum + "\"]}", headers);

		ResponseEntity<String> response = null;
		try {
			response = rest.postForEntity(HTTPS_URL_SELLAR, requestEntity, String.class);
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		}
		String body = response.getBody();

		return body;

	}

	private static String getFileChecksum(MessageDigest digest, byte[] file) throws IOException {
		ByteArrayInputStream fis = new ByteArrayInputStream(file);

		byte[] byteArray = new byte[1024];
		int bytesCount = 0;

		while ((bytesCount = fis.read(byteArray)) != -1) {
			digest.update(byteArray, 0, bytesCount);
		}
		;

		fis.close();

		byte[] bytes = digest.digest();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}
}
