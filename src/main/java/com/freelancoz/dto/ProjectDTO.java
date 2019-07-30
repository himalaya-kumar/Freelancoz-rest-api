package com.freelancoz.dto;

import java.util.ArrayList;
import java.util.List;

public class ProjectDTO {

	private Long id;
	private String projectName;
	private List<LancerDTO> lancerDTOs = new ArrayList<>();
	private ClientDTO clientDTO;
	
	public String json() {
		
		return "";
	}
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

	public List<LancerDTO> getLancerDTOs() {
		return lancerDTOs;
	}

	public void setLancerDTOs(List<LancerDTO> lancerDTOs) {
		this.lancerDTOs = lancerDTOs;
	}

	public ClientDTO getClientDTO() {
		return clientDTO;
	}

	public void setClientDTO(ClientDTO clientDTO) {
		this.clientDTO = clientDTO;
	}
}