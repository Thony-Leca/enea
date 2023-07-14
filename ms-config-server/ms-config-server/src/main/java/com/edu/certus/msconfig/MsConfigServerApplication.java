package com.edu.certus.msconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class MsConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsConfigServerApplication.class, args);
	}

}
