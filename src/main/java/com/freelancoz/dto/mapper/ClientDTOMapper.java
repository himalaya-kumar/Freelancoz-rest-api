package com.freelancoz.dto.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.freelancoz.dto.AddressDTO;
import com.freelancoz.dto.ClientDTO;
import com.freelancoz.model.Address;
import com.freelancoz.model.Client;
import com.freelancoz.model.Project;
import com.freelancoz.repositories.AddressRepository;
import com.freelancoz.service.ProjectService;

@Component
public class ClientDTOMapper {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ProjectService projectService;
	
	public ClientDTOMapper() {}

	public ClientDTO fromCleint(Client client) {
		AddressDTO addressDTO = new AddressDTO(client.getAddress().getId(),client.getAddress().getCity());
		Set<Long> projectIds = client.getProjectSet().stream().map(Project::getId).collect(Collectors.toSet());
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setId(client.getId());
		clientDTO.setClientName(client.getName());
		clientDTO.setAddressDTO(addressDTO);
		clientDTO.setProjectIds(projectIds);
		return clientDTO;
	}

	public Client fromDTO(ClientDTO clientDTO) {
		Address address = getAddress(clientDTO.getAddressDTO());
		Client client = new Client();
		client.setId(clientDTO.getId());
		client.setAddress(address);
		client.setProjectSet(projectSet(clientDTO.getProjectIds()));
		client.setName(clientDTO.getClientName());
		return client;
	}
	
	private Address getAddress(AddressDTO addressDTO) {		
		return addressRepository.findById(addressDTO.getId()).get();
	}
	
	private Set<Project> projectSet(Set<Long> projectIdList){
		return projectIdList.stream().map(projectService::getProject).collect(Collectors.toSet());
	}
}