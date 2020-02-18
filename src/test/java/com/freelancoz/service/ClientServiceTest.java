package com.freelancoz.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.freelancoz.model.Client;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

	@Autowired
	private ClientService clientService;
	
	private Client client;
	
	@Before
	public void prerequsite() {
		client = new Client();
	}
	
	@Test
	public void createNewClient() {
		clientService.saveOrUpdateClient(client);
		assertNotNull(client.getId()+"", client.getId());
		System.out.println("*****************"+client.getId()+"*********************");
	}
	
	@Test
	public void getClientById() {
		clientService.saveOrUpdateClient(client);
		clientService.getClient(client.getId());
		assertNotNull(client.getId()+"is not present", client);
		System.out.println("*****************"+client.getId()+"*********************");
	}
	
	@Test
	public void updateClientNameSetter() {
		clientService.saveOrUpdateClient(client);
		Client clientUpdate = clientService.getClient(client.getId());
		clientUpdate.setName("Client Name");
		clientService.saveOrUpdateClient(clientUpdate);
		
		Client updatedClient =clientService.getClient(client.getId());
		assertNotNull(client.getId()+" is not present",updatedClient.getName());
		System.out.println("*****************"+updatedClient.getName()+"*********************");
	}
	
	@Test
	public void updateClientSetter() {
		
	}
	
}