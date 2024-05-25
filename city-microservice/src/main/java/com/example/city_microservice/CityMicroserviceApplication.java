package com.example.city_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class CityMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityMicroserviceApplication.class, args);
	}

}
