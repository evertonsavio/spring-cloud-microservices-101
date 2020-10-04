package br.com.padotec.usersmicroservice.padousers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PadoUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadoUsersApplication.class, args);
	}

}
