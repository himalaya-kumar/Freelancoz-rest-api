package com.freelancoz.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelancoz.model.Client;
import com.freelancoz.repositories.ClientRepository;
import com.freelancoz.service.ClientService;

@Transactional
@Service
public class ClientServiceImplementation implements ClientService{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Boolean isClientExist(Long clientId) {
		return clientRepository.existsById(clientId);
	}

	@Override
	public Client getClient(Long id) {
		return clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Wrong Client ID"));
	}

	@Override
	public List<Client> getAllClient() {
		return StreamSupport.stream(clientRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	
	@Override
	public void saveOrUpdateClient(Client client) {
		clientRepository.save(client);
	}

	@Override
	public void deleteClient(Client client) {
		clientRepository.delete(client);
	}
}