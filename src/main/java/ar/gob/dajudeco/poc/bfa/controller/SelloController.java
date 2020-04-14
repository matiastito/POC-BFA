package ar.gob.dajudeco.poc.bfa.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ar.gob.dajudeco.poc.bfa.servicio.BFA;

@RestController
public class SelloController {

	@PostMapping("/validar")
	@ResponseStatus(HttpStatus.OK)
	public String validar(@RequestParam("file") MultipartFile file) throws NoSuchAlgorithmException, IOException {
		return new BFA().verify(file.getBytes());
	}

	@PostMapping("/sellar")
	@ResponseStatus(HttpStatus.CREATED)
	public String sellar(@RequestParam("file") MultipartFile file) throws NoSuchAlgorithmException, IOException {
		return new BFA().sellar(file.getBytes());
	}
}
