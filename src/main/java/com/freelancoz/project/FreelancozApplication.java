package com.freelancoz.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.freelancoz.model")
@EnableJpaRepositories(basePackages = "com.freelancoz.repositories")
@ComponentScan(basePackages = {"com.freelancoz.controllers","com.freelancoz.model",
		"com.freelancoz.project","com.freelancoz.serviceImpl","com.freelancoz.repositories"})
@EnableTransactionManagement
public class FreelancozApplication{

	public static void main(String[] args){
		SpringApplication.run(FreelancozApplication.class, args);
	}
}