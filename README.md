# POC BFA

### Instalar JAVA 8 (JRE)

1. Instalar JAVA JRE 8 https://www.oracle.com/java/technologies/javase-jre8-downloads.html
2. Configurar las __variables de entorno__. Agregar:

* CLASSPATH: C:\Program Files\Java\jdk1.7.0_79\jre
* JAVA_HOME: C:\Program Files\Java\jdk1.7.0_79
* PATH: ....;C:\Program Files\Java\jdk1.7.0_79\bin;....

### Instalar MAVEN

http://maven.apache.org/download.cgi#Installation

1. __DESCARGAR__ el binario en zip o tar.
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
