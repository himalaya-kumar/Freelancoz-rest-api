package com.freelancoz.dto;

import java.util.ArrayList;
import java.util.List;

public class LancerDTO {

    private Long id;

    private String name;

    private AddressDTO addressDTO;

    private List<ProjectDTO> projectList = new ArrayList<>();

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

	public List<ProjectDTO> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProjectDTO> projectList) {
		this.projectList = projectList;
	}
}
