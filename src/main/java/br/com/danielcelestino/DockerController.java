package br.com.danielcelestino;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
	
	Logger logger = LoggerFactory.getLogger(DockerController.class);
	
	@RequestMapping("/hello-docker")
	public HelloDocker greeting() {
		
		logger.info("Endpoint /hello-docker is called");
		
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
 *  docker tag hello-docker:0.0.2-SNAPSHOT danielcelestino/hello-docker:0.0.2-SNAPSHOT
 *  
 * 5) logando no doker hub (powershell)
 * docker login docker.io
 *  
 * 6) Enviando a aplicação
 * docker push danielcelestino/hello-docker:0.0.1-SNAPSHOT
 * docker push danielcelestino/hello-docker:0.0.2-SNAPSHOT
 * 
 * 7) apos apagar imagens do docker local... rodar imagens que estão no docker hub
 * docker run -p 80:80 -d danielcelestino/hello-docker:0.0.1-SNAPSHOT
 * docker run -p 81:80 -d danielcelestino/hello-docker:0.0.2-SNAPSHOT
 * docker run -p 81:80 -d danielcelestino/hello-docker   (pega a latest)
 * 
 * 7.1) Rodando container para inicar juntamento com o docker
 * docker run -p 81:80 -d --restart=always danielcelestino/hello-docker   (pega a latest)
 * 
 * 7,2) Subindo container limitando a memoria e cpu
 * docker run -p 81:80 -d -m 512m --cpu-quota 5000 danielcelestino/hello-docker   (512 mb e 5% -- 50000 = 20%  ---- 100000 = 100%)
 * 
 * 8) listando container
 * docker container ls  *
 * docker ps
 * docker container ps
 * docker container ps -a (mostra os encerrados)
 * 
 * 9) parando container
 * docker container stop 2c   (2c pode ser uma parte do ID)
 * docker stop 
 * 
 * 10) log dos container
 * docker logs 2c (2c pode ser uma parte do ID)
 * 
 * 11) logs em tempo real
 * docker logs -f 2c (2c pode ser uma parte do ID)
 * 
 * 12) Baixando imagem do registry / Baicando conainer image para maquina
 * docker pull mysql
 * 
 * 13) gerando a versão latest 
 * docker tag danielcelestino/hello-docker:0.0.1-SNAPSHOT danielcelestino/hello-docker:latest
 * 
 * 14) procurando por docker images (pode ser feito no site do https://hub.docker.com/)
 * docker search mysql
 * docker search mysql --filter is-official=true
 * 
 * 15) Vendo historico da image (apos feito o pull)
 * docker image history 2c
 * 
 * 16) Inspecionando image (apos feito o pull)
 * docker image inspect 2c
 * 
 * 17) Removendo image (apos feito o pull)
 * docker image remove 2c
 * docker rmi 2c
 * docker rmi 2c -f (forçar)
 * 
 * 18) Pausar/Unpause container
 * docker container pause 2c
 * docker container unpause 2c
 * 
 * 19) Inspecionando container 
 * docker container inspect 2c
 * 
 * 20) Deleta container que não estão em wxecução
 * docker container prune 
 * 
 * 21) Forçar parada do container
 * docker container kill 2c 
 * 
 * 22) Acompanhar eventos do docker (vai mostrando o que acontece no container)
 * docker events
 * 
 * 23) Ver processo em execução em um container especifico
 * docker top 2c
 * 
 * 24) Estatisticas da maquina
 * docker stats
 * 
 * 25) Vendo imagens do sistema
 * docker system df
 * 
 * 
 * 
 * ##################
 * Docker Compose
 * 1) rodando arquivo yml (na pasta do aruivo no power shel)
 * docker-compose up
 * docker-compose up -d
 * 
 * 2) Parando tudo
 * docker-compose down
 * 
 * 3) Listando os containers relacionados ao docker-compose
 * docker-compose ps
 * 
 */