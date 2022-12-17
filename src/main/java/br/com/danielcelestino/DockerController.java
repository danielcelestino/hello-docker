package br.com.danielcelestino;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
	
	@RequestMapping("/hello-docker")
	public HelloDocker greeting() {
		
		//var hostName = System.getenv("COMPUTERNAME");
		var hostName = System.getenv("HOSTNAME");
		
		return new HelloDocker(
					"Hello Docker",
					hostName
				);
	}
}


/**
 * 0) Testando o container (no poweshell)
 * docker run hello-world
 * 
 * 1) Para gerar o jar: 
 * Clique com direito no projeto / Show in Terminal
 * mvn clean package -DskipTests
 * 
 * 2) Copie o nome do jar na pasta target (no terminal)
 * docker build -t hello-docker:0.0.1-SNAPSHOT .
 * docker build -t cambio-service:0.0.1-SNAPSHOT ./diretorio (se tiver diretorios)
 * 
 * 3)listar imagens (no poweshell)
 * docker images
 * 
 * 4) renomeando a tag para publicar no hub (powershell)
 *  docker tag hello-docker:0.0.1-SNAPSHOT danielcelestino/hello-docker:0.0.1-SNAPSHOT
 *  
 * 5) logando no doker hub (powershell)
 * docker login docker.io
 *  
 * 6) Enviando a aplicação
 * docker push danielcelestino/hello-docker:0.0.1-SNAPSHOT
 * 
 */