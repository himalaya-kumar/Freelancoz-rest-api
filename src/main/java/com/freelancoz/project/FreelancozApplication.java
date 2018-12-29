package com.freelancoz.project;

import com.freelancoz.controllers.HomePageController;
import com.freelancoz.repositories.AddressRepository;
import com.freelancoz.repositories.ClientRepository;
import com.freelancoz.repositories.LancerRepository;
import com.freelancoz.repositories.ProjectRepository;
import com.freelancoz.serviceImpl.AddressServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.freelancoz.model")
@EnableJpaRepositories(basePackages = "com.freelancoz.repositories")
@ComponentScan(basePackageClasses = { AddressRepository.class, ClientRepository.class, LancerRepository.class,
		ProjectRepository.class, AddressServiceImpl.class, HomePageController.class})
public class FreelancozApplication{

	public static void main(String[] args){
		SpringApplication.run(FreelancozApplication.class, args);
	}
}