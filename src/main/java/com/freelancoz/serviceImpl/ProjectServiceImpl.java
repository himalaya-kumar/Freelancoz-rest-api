package com.freelancoz.serviceImpl;

import com.freelancoz.model.Project;
import com.freelancoz.repositories.ProjectRepository;
import com.freelancoz.serviceInterface.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public Project getProject(Long id) {
        return null;
    }

    @Override
    public List<Project> getAllProjects() {
        return null;
    }
}
