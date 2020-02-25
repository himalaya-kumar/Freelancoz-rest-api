package com.freelancoz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FreelancozApiApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(FreelancozApiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initDatabase() {
		return args -> {
			System.out.println("Hello my name is himalaya Kumar");
		};
	}
}