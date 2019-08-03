package com.freelancoz;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.freelancoz.model.Client;
import com.freelancoz.repositories.AddressRepository;
import com.freelancoz.service.ClientService;
import com.freelancoz.service.LancerService;
import com.freelancoz.service.ProjectService;

@Component
public class FreelancozRunner implements CommandLineRunner {

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
	
	@Override
	public void run(String... args) throws Exception {
		
//		IntStream.range(0, 10).forEach(i -> {
//
//			Address contactInformation = new Address("NYC" + i);
//			Address contactInformation1 = new Address("LON" + i);
//			Address contactInformation2 = new Address("TOK" + i);
//
//			Project projectOne = new Project("ProjectOne" + i);
//			Project projectTwo = new Project("ProjectTwo" + i);
//			Lancer lancer = new Lancer("one" + i, contactInformation1);
//			Lancer lancer1 = new Lancer("two" + i, contactInformation2);
//
//			projectOne.setLancerList(Arrays.asList(lancer, lancer1));
//			projectTwo.setLancerList(Arrays.asList(lancer, lancer1));
//
//			lancer.addProject(projectOne);
//			lancer.addProject(projectTwo);
//
//			lancer1.addProject(projectOne);
//			lancer1.addProject(projectTwo);
//
//			Client client = new Client("Hi" + i, contactInformation);
//			client.addProject(projectOne);
//			client.addProject(projectTwo);
//
//			addressRepository.save(contactInformation);
//			addressRepository.save(contactInformation1);
//			addressRepository.save(contactInformation2);
//			clientService.saveOrUpdateClient(client);
//			projectService.saveOrUpdateProject(projectOne);
//			projectService.saveOrUpdateProject(projectTwo);
//			lancerService.saveOrUpdateLancer(lancer);
//			lancerService.saveOrUpdateLancer(lancer1);
//
//		});
//
//		Address contactInformation = new Address("NYC");
//		Address contactInformation1 = new Address("LON");
//		Address contactInformation2 = new Address("TOK");
//
//		Project projectOne = new Project("ProjectOne");
//		Project projectTwo = new Project("ProjectTwo");
//		Lancer lancer = new Lancer("one", contactInformation1);
//		Lancer lancer1 = new Lancer("two", contactInformation2);
//
//		projectOne.setLancerList(Arrays.asList(lancer, lancer1));
//		projectTwo.setLancerList(Arrays.asList(lancer, lancer1));
//
//		lancer.addProject(projectOne);
//		lancer.addProject(projectTwo);
//
//		lancer1.addProject(projectOne);
//		lancer1.addProject(projectTwo);
//
//		Client client = new Client("Hi", contactInformation);
//		client.addProject(projectOne);
//		client.addProject(projectTwo);
//		
//		addressRepository.save(contactInformation);
//		addressRepository.save(contactInformation1);
//		addressRepository.save(contactInformation2);
//		clientService.saveOrUpdateClient(client);
//		projectService.saveOrUpdateProject(projectOne);
//		projectService.saveOrUpdateProject(projectTwo);
//		lancerService.saveOrUpdateLancer(lancer);
//		lancerService.saveOrUpdateLancer(lancer1);
		
	}
}