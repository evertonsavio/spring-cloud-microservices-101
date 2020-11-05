# JAVA Spring Cloud Microservices (NETFLIX Stack)

* Adicionar a anotacao @EnableEurekaServer na classe principal.  
  
*Adicionar em resources/application.properties:
```
server.port=8010
spring.application.name=discoveryservice
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
eureka.client.serviceUrl.defaultZone = "http://localhost:8010/eureka"
```  
--------------
### Criar Users Microservice  

* @EnableDiscoveryClient na classe principal e em application.properties:  
```
server.port=0
spring.application.name=users-ws
eureka.client.serviceUrl.defaultZone = http://localhost:8010/eureka
spring.devtools.restart.enabled = true
```  
  
### ERROR: RabbitMQ started but can't access management interface
* Solution: rabbitmq-plugins enable rabbitmq_management  
  
### mappingModel List<UserDto>
* https://www.baeldung.com/java-modelmapper-lists  
  
### AWS 
  
* Gerar chave, baixar. No diretorio da chave executar:  
```
chmod 400 mykey.pem
  
ssh -i "aws-microservices-keypair.pem" ec2-user@ec2-18-230-82-253.sa-east-1.compute.amazonaws.com
  
sudo yum update
```
  
### Docker Commands Cheat Sheet

* http://appsdeveloperblog.com/docker-commands-cheat-sheet/

  
* Install Docker on AWS EC2
```
    sudo yum install docker  
    sudo service docker start  
    sudo usermod -a -G docker ec2-user  
    exit  
    ssh -i "aws-microservices-keypair.pem"  ec2-user@ec2-18-230-82-253.sa-east-1.compute.amazonaws.com  
    docker info
```
  
* Run RabbitMQ Docker Container
```  
docker run -d --name rabbit-name-management -p 15672:15672 -p 5672:5672 -p 15671:15671 -p 5671:5671 -p 4369:4369 rabbitmq:3-management
```
#### -d Enable to close terminar and rabbiq continue running
```
docker ps
docker stop CONTAINER ID
docker ps --all
docker start CONTAINER
```
  
* Configurar nos grubos de segurança da AWS as regras de entrada:
```
Tipo: TCP personalizado
Protocolo: TCP
Intervalo de portas: e.g portas do rabbitmq
Origem: Qualuquer lugar 
```
  
* Conectar ao RabbitMQ: Endereco publico mais a porta 15672
```
http://ec2-18-230-82-253.sa-east-1.compute.amazonaws.com:15672/
```
  
### DOCKER FAST COMMANDS  
```
docker ps
docker ps -a
docker run -d --name different_name -> CREATE CONTAINNER
docker stop CONTAINER_ID
docker start CONTAINER_ID -> INICIALIZA O CONTAINNER
docker rm CONTAINER ID -> STILL HAS IMAGES
docker images
docker rmi IMAGE_ID -f
```
  
* To run RabbitMQ and change Default user name and password:
  
````
docker run -d --name rabbit-name-management -p 15672:15672 -p 5672:5672 -p 5671:5671 -e RABBITMQ_DEFAULT_USER=user –e RABBITMQ_DEFAULT_PASS=password rabbitmq:3-management
```
    
### Run Config Server Docker Container (Criar dockerfile antes of course)  
  
```  
docker run -d -p 8012:8012 -e "spring.rabbitmq.host=172.17.0.2" evertonsavio/config-server
```

* Run Eureka Docker Container
```
docker run -d -p 8010:8010 -e "spring.cloud.config.uri=http://172.31.0.133:8012" evertonsavio/sk-eureka-server
```

* Run Zuul API Gateway Docker Container
```
docker run -d -e "spring.cloud.config.uri=http://99.79.172.54:8012" -e "spring.rabbitmq.host=99.79.172.54" -p 8011:8011 evertonsavio/sk-zuul-api-gateway
```

* Run Elasticsearch Docker Container
```
docker run -d --name elasticsearch --network api_network -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:7.3.0
```

* Run Kibana Docker Container
```
docker run -d --network api-network -p 5601:5601 kibana:7.3.0
```

* Run Albums Microservice Docker Container

```
docker run -it -d -e "eureka.client.serviceUrl.defaultZone=http://test:test@99.79.99.76:8010/eureka" --network host -e "logging.file=/api-logs/albums-ws.log" -v /home/ec2-user/api-logs:/api-logs evertonsavio/albums-microservice
```

* Run Logstash for Albums Microservice Docker Container
```
docker run -d --name logstash /home/ec2-user/api-logs:/api-logs evertonsavio/sk-albums-microservice-logstash
```

* Run MySQL Docker Container
```
docker run –d -p 3306:3306 --name mysql-docker-container -e MYSQL_ROOT_PASSWORD=sergey -e MYSQL_DATABASE=photo_app -e MYSQL_USER=sergey -e MYSQL_PASSWORD=sergey mysql:latest
```

* Run Users Microservice Docker Container
```
docker run -d -e "spring.cloud.config.uri=http://172.31.4.43:8012" -e "spring.rabbitmq.host=172.31.4.43" -e "eureka.client.serviceUrl.defaultZone=http://test:test@172.31.18.99:8010/eureka" -e "spring.datasource.url=jdbc:mysql://172.31.13.167:3306/photo_app?serverTimezone=UTC" --network host -e "logging.file=/api-logs/users-ws.log" -v /home/ec2-user/api-logs:/api-logs evertonsavio/sk-users-microservice
```

* Run Logstash for Users Microservice
```
docker run -d --name users-ws-logstash /home/ec2-user/home:/api-logs evertonsavio/sk-users-ws-logstash
```