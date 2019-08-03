package com.freelancoz.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<ClientDTO>> getAllClient(){
		
		List<ClientDTO> clientDto = clientService.getAllClient()
 												 .stream()
												 .map(new ClientDTOMapper()::fromCleint)
												 .collect(Collectors.toList());
		
		return new ResponseEntity<List<ClientDTO>> (clientDto,HttpStatus.OK);
	}
	
	@PostMapping("/getClient/{id}")
	public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) {
		Client client =clientService.getClient(id);
		return new ResponseEntity<ClientDTO>(clientDTOMapper.fromCleint(client),HttpStatus.OK);
	}
	
	@PostMapping("/saveClient")
	public ResponseEntity<String> saveClient(@RequestBody ClientDTO clientDTO) {
		Client client = clientDTOMapper.fromDTO(clientDTO);
		clientService.saveOrUpdateClient(client);
		return new ResponseEntity<String>("client is saved",HttpStatus.OK);
	}

	@PostMapping("/deleteClient/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable Long id) {
		Client client = clientService.getClient(id);
		clientService.deleteClient(client);
		return new ResponseEntity<String>("clientIsDeleted",HttpStatus.OK);
	}
}