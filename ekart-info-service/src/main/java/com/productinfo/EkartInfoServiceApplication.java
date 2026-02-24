package com.productinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EkartInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkartInfoServiceApplication.class, args);
	}

}
