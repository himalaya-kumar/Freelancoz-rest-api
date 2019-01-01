package com.freelancoz.project;

import com.freelancoz.model.Client;
import com.freelancoz.model.ContactInformation;
import com.freelancoz.model.Lancer;
import com.freelancoz.model.Project;
import com.freelancoz.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;


@SpringBootApplication
@EntityScan(basePackages = "com.freelancoz.model")
@EnableJpaRepositories(basePackages = "com.freelancoz.repositories")
@ComponentScan(basePackages = {"com.freelancoz.controllers","com.freelancoz.model",
		"com.freelancoz.project","com.freelancoz.serviceImpl","com.freelancoz.repositories"})
@EnableTransactionManagement
@ConfigurationProperties
@PropertySource("application.properties")
public class FreelancozApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args){
		SpringApplication.run(FreelancozApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ContactInformation contactInformation = new ContactInformation("NYC","PASSADENA","12345","1234676489","heloo@gmail.com");
		Client client = new Client("Hi", contactInformation);
		Project projectOne = new Project("ProjectOne");
		Project projectTwo = new Project("ProjectTwo");
//        client.setProjectSet(Stream.of(projectOne,projectTwo).collect(Collectors.toSet()));
		Lancer lancer = new Lancer("one", contactInformation);
		Lancer lancer1 = new Lancer("two", contactInformation);
		projectOne.setClient(client);
		projectTwo.setClient(client);

		projectOne.setLancerList(Arrays.asList(lancer,lancer1));
		projectTwo.setLancerList(Arrays.asList(lancer,lancer1));

		lancer.setProjectList(Arrays.asList(projectOne,projectTwo));
		lancer1.setProjectList(Arrays.asList(projectOne,projectTwo));
		clientRepository.save(client);
	}
}