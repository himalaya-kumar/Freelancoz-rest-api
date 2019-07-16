package com.freelancoz.dto.mapper;

import org.springframework.stereotype.Component;

import com.freelancoz.dto.ProjectDTO;
import com.freelancoz.model.Project;

@Component
public class ProjectDTOMapper {

	
	public ProjectDTOMapper() { }
	
	public ProjectDTO fromObj(Project project) {
//		ProjectDTO projectDTO = new ProjectDTO();
//		projectDTO.setId(project.getId());
//		projectDTO.setProjectName(project.getProjectName());
//		projectDTO.setLancerId(project.getLancerList().stream().map(e -> e.getId()).collect(Collectors.toList()));
		return null;
	}
	
	public Project fromDTO(ProjectDTO projectDTO) {
//		Project project = projectService.getProject(projectDTO.getId());
		return null;
	}
}