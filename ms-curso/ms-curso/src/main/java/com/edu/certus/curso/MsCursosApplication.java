package com.edu.certus.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class MsCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCursosApplication.class, args);
	}

}
