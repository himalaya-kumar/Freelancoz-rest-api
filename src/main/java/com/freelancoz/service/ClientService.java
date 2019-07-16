package com.freelancoz.service;

import java.util.List;

import com.freelancoz.model.Client;

public interface ClientService {

	Boolean isClientExist(Long id);
	
	Client getClient(Long id);
	
	List<Client> getAllClient();
	
	void saveOrUpdateClient(Client client);
	
	void deleteClient(Client client);
}
