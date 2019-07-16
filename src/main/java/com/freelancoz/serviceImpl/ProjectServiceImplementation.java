package com.freelancoz.serviceImpl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelancoz.model.Project;
import com.freelancoz.repositories.ProjectRepository;
import com.freelancoz.service.ProjectService;

@Transactional
@Service
public class ProjectServiceImplementation implements ProjectService {

	@Autowired
	private  ProjectRepository projectRepository;
	
	@Override
	public Boolean isProjectExist(Long projectId) {
		
		return projectRepository.existsById(projectId);
	}

	@Override
	public Project getProject(Long id) {
		return projectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Wrong Client ID"));
	}

	@Override
	public List<Project> getAllProject() {
		return StreamSupport.stream(projectRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public void saveOrUpdateProject(Project project) {
		projectRepository.save(project);
	}

	@Override
	public void deleteLancer(Project project) {
		projectRepository.delete(project);
	}

	@Override
	public Set<Project> getAllProject(Set<Long> ids) {
		return StreamSupport.stream(projectRepository.findAllById(ids).spliterator(), false).collect(Collectors.toSet());
	}
}