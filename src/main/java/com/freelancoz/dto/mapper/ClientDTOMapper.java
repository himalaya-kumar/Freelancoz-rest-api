package com.freelancoz.dto.mapper;

import org.springframework.stereotype.Component;

import com.freelancoz.dto.ClientDTO;
import com.freelancoz.model.Client;

@Component
public class ClientDTOMapper {
	
	
	public ClientDTOMapper() {}

	public ClientDTO from(Client client) {
//		ClientDTO clientDTO = new ClientDTO();
//		clientDTO.setId(client.getId());
//		clientDTO.setClientName(client.getName());
//		clientDTO.setAddressId(client.getAddress().getId());
//		clientDTO.setProjectIds(client.getProjectSet().stream().map(Project::getId).collect(Collectors.toSet()));
		return null;
	}

	public Client fromDTO(ClientDTO clientDTO) {
//		Address address = addressRepository.findById(clientDTO.getAddressId()).orElseThrow(IllegalArgumentException::new);
//		
//		Set<Project> projects = projectService.getAllProject(clientDTO.getProjectIds());
//		Client client = new Client(clientDTO.getClientName(),address);
//		client.setName(clientDTO.getClientName());
//		client.setAddress(address);
//		projects.stream().forEach(client::addProject);
		return null;
	}
}