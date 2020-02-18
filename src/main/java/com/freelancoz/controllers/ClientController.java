package com.freelancoz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.freelancoz.model.Client;
import com.freelancoz.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;
		
	@GetMapping("/getAllClient")
	public ResponseEntity<List<Client>> getAllClient(){
		return new ResponseEntity<List<Client>>(clientService.getAllClient(),HttpStatus.OK);
	}
	
	@PostMapping("/getClient/{id}")
	public ResponseEntity<Client> getClient(@PathVariable Long id) {
		return new ResponseEntity<Client>(clientService.getClient(id),HttpStatus.OK);
	}
	
	@PostMapping("/saveClient")
	public ResponseEntity<String> saveClient(@RequestBody Client client) {
		clientService.saveOrUpdateClient(client);
		return new ResponseEntity<String>("client is saved",HttpStatus.OK);
	}

	@PostMapping("/deleteClient/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable Long id) {
		clientService.deleteClient(clientService.getClient(id));
		return new ResponseEntity<String>("clientIsDeleted",HttpStatus.OK);
	}
}