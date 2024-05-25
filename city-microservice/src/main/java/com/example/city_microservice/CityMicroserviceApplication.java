package com.example.city_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CityMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityMicroserviceApplication.class, args);
	}

}
