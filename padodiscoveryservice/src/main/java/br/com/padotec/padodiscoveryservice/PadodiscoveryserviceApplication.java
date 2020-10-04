package br.com.padotec.padodiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PadodiscoveryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadodiscoveryserviceApplication.class, args);
	}

}
