package com.freelancoz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelancoz.model.Project;
import com.freelancoz.service.ProjectService;

@RestController("lancer")
public class LancerController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/getProjectList")
	public List<Project> getAllProject(){
		return projectService.getAllProject();
	}
	
	@PostMapping("/getProject/{id}")
	public Project getProject(@PathVariable Long id) {
		return projectService.getProject(id);
	}
}