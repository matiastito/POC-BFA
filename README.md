# POC BFA

### Instalar JAVA 8 (JRE)

1. Instalar JAVA JRE 8 (https://www.oracle.com/java/technologies/javase-jre8-downloads.html)
2. Configurar las __variables de entorno__. Agregar:

* CLASSPATH: __C:\Program Files\Java\jdk1.8.X_XX__\jre
* JAVA_HOME: __C:\Program Files\Java\jdk1.8.X_XX__
* PATH: ....;__C:\Program Files\Java\jdk1.8.X_XX__\bin;....

NOTA: __C:\Program Files\Java\jdk1.8.X_XX__ debe ser el lugar donde instaló la JRE descargada en el paso 1.

### Instalar MAVEN

1. __DESCARGAR__ el binario en zip o tar (http://maven.apache.org/download.cgi#Installation).
2. __DESCOMPRIMIR__ el archivo en C:/maven, los archivos de Maven se encontrarán en C:/maven/apache-maven-X.X.X
3. Configurar las __variables de entorno__. Agregar:

* M2: %M2_HOME%\bin
* M2_HOME: C:\maven\apache-maven-X.X.X
* PATH: ....;C:\maven\apache-maven-X.X.X\bin;....


# 1. Iniciar la POC
```
$ git clone https://github.com/mkyong/spring-boot.git
$ cd pocBFA
$ mvn spring-boot:run
```

Acceder a la app http://localhost:8080
