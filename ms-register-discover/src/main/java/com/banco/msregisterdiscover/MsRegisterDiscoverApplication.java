package com.banco.msregisterdiscover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsRegisterDiscoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRegisterDiscoverApplication.class, args);
	}

}
