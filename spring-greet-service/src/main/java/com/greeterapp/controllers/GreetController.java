package com.greeterapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@GetMapping("/greet/{username}")
	String greetUser(@PathVariable String username) {
		return "Welcome to microservices "+username;
	}
	
	@GetMapping("/show-courses")
	List<String> showCourses() {
		return List.of("Java","React","Microservices");
	}
}
