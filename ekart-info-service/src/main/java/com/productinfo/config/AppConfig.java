package com.productinfo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

	@Bean
	@LoadBalanced
	RestClient.Builder builder(){
		return RestClient.builder(); // return the Builder object
	}
}
