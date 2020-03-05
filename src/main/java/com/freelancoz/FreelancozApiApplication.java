package com.freelancoz;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.freelancoz.model.Address;
import com.freelancoz.model.Client;
import com.freelancoz.model.Lancer;
import com.freelancoz.model.Project;
import com.freelancoz.repositories.AddressRepository;
import com.freelancoz.service.ClientService;
import com.freelancoz.service.LancerService;
import com.freelancoz.service.ProjectService;

@SpringBootApplication
public class FreelancozApiApplication{
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private LancerService lancerService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private AddressRepository addressRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(FreelancozApiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initDatabase() {
		return args -> {
			System.out.println("Saving structure of project");
			
			/**
			 * Address for the client
			 */
			Address addressClient = Address.builder().city("Address Client").build();
			Address addressLancerOne = Address.builder().city("Address Lancer").build();
			addressRepository.saveAll(Arrays.asList(addressClient,addressLancerOne));
			
			/**
			 * Client
			 */
			Client client = Client.builder().name("Client One").address(addressClient).build();
			clientService.saveOrUpdateClient(client);
			
			/**
			 * Project
			 */
			Project project = Project.builder().client(client).projectName("Project One").build();
			projectService.saveOrUpdateProject(project);
			
			/**
			 * Lancer One
			 */
			Lancer lancer = Lancer.builder().name("Lancer One").address(addressLancerOne).projectList(Arrays.asList(project)).build();
			lancerService.saveOrUpdateLancer(lancer);
			
		};
	}
}