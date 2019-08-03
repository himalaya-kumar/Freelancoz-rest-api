package com.freelancoz.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.freelancoz.dto.ProjectDTO;
import com.freelancoz.model.Lancer;
import com.freelancoz.model.Project;

@Component
public class ProjectDTOMapper {
	
	@Autowired
	private ClientDTOMapper clientDTOMapper;

	public ProjectDTOMapper() { }
	
	public ProjectDTO fromProject(Project project) {
		List<Long> lancerIdList = project.getLancerList().stream().map(Lancer::getId).collect(Collectors.toList());
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setId(project.getId());
		projectDTO.setClientDTO(clientDTOMapper.fromCleint(project.getClient()));
		projectDTO.setProjectName(project.getProjectName());
		projectDTO.setLancerIdList(lancerIdList);
		return projectDTO;
	}
	
	public Project fromProjectDTO(ProjectDTO projectDTO) {
		Project project = new Project();
		project.setId(projectDTO.getId());
		return project;
	}
}