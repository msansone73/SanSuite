package br.com.msansone.saneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class SanEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanEurekaApplication.class, args);
	}

}
