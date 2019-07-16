package com.freelancoz.service;

import java.util.List;
import java.util.Set;

import com.freelancoz.model.Project;

public interface ProjectService {

	Boolean isProjectExist(Long projectId);
	
	Project getProject(Long id);
	
	List<Project> getAllProject();
	
	void saveOrUpdateProject(Project project);
	
	void deleteLancer(Project project);

	Set<Project> getAllProject(Set<Long> ids);
}
