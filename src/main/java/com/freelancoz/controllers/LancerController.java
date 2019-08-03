package com.freelancoz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelancoz.dto.ProjectDTO;
import com.freelancoz.dto.mapper.ProjectDTOMapper;
import com.freelancoz.model.Project;
import com.freelancoz.service.ProjectService;

@RestController
public class LancerController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectDTOMapper projectDTOMapper;

	@GetMapping("/getProjectList")
	public List<ProjectDTO> getAllProject(){
		return null;
	}
	
	@PostMapping("/getProject/{id}")
	public ProjectDTO getProject(@PathVariable Long id) {
		Project project = projectService.getProject(id);
		return projectDTOMapper.fromProject(project);
	}
}