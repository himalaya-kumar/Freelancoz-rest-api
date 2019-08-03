package com.freelancoz.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LancerDTO {

    private Long id;

    private String name;

    private AddressDTO addressDTO;

    private List<Long> projectidList = new ArrayList<>();
        
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	public List<Long> getProjectidList() {
		return projectidList;
	}

	public void setProjectidList(List<Long> projectidList) {
		this.projectidList = projectidList;
	}
	
    public String json() throws JsonProcessingException {
    	return new ObjectMapper().writeValueAsString(this);
    }

}