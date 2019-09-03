package com.banco.mscargo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
public class MsCargoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCargoApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
	return Sampler.ALWAYS_SAMPLE;
	}

}
