package com.freelancoz.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.freelancoz.dto.ClientDTO;
import com.freelancoz.dto.mapper.ClientDTOMapper;
import com.freelancoz.model.Client;
import com.freelancoz.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClientDTOMapper clientDTOMapper;
	
	@GetMapping("/getAllClient")
	public List<ClientDTO> getAllClient(){
		return clientService.getAllClient().stream().map(new ClientDTOMapper()::from).collect(Collectors.toList());
	}
	
	@PostMapping("/getClient/{id}")
	public ClientDTO getClient(@PathVariable Long id) {
		Client client =clientService.getClient(id);
		return clientDTOMapper.from(client);
	}
	
	@PostMapping("/saveClient")
	public String saveClient(@RequestBody ClientDTO clientDTO) {
		Client client = clientDTOMapper.fromDTO(clientDTO);
		clientService.saveOrUpdateClient(client);
		return "client is saved";
	}

	@PostMapping("/deleteClient/{id}")
	public String deleteClient(@PathVariable Long id) {
		Client client = clientService.getClient(id);
		clientService.deleteClient(client);
		return "clientIsDeleted";
	}
}