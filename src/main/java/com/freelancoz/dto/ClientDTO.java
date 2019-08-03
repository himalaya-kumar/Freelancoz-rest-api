package com.freelancoz.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientDTO {

	private Long id;
	
	private String clientName;
	
	private AddressDTO addressDTO;
	
	private Set<Long> projectIds = new HashSet<>();
	
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
	
	public Set<Long> getProjectIds() {
		return projectIds;
	}

	public void setProjectIds(Set<Long> projectIds) {
		this.projectIds = projectIds;
	}

	public String json() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(this);
	}
}