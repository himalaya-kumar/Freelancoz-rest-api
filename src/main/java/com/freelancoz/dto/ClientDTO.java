package com.freelancoz.dto;

import java.util.HashSet;
import java.util.Set;

public class ClientDTO {

	private Long id;
	
	private String clientName;
	
	private AddressDTO addressDTO;
	
	private Set<ProjectDTO> projectDTOs = new HashSet<>();
	
	public ClientDTO() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	public Set<ProjectDTO> getProjectDTOs() {
		return projectDTOs;
	}

	public void setProjectDTOs(Set<ProjectDTO> projectDTOs) {
		this.projectDTOs = projectDTOs;
	}
}