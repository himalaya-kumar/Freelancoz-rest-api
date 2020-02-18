package com.freelancoz.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProjectDTO {

	private Long id;
	private String projectName;
	private List<Long> lancerIdList = new ArrayList<>();
	private ClientDTO clientDTO;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public ClientDTO getClientDTO() {
		return clientDTO;
	}

	public void setClientDTO(ClientDTO clientDTO) {
		this.clientDTO = clientDTO;
	}
	public List<Long> getLancerIdList() {
		return lancerIdList;
	}
	public void setLancerIdList(List<Long> lancerIdList) {
		this.lancerIdList = lancerIdList;
	}
	
	public String json() throws JsonProcessingException {		
		return new ObjectMapper().writeValueAsString(this);
	}
}