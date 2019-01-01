package com.freelancoz.serviceInterface;

import com.freelancoz.model.Project;

import java.util.List;

public interface ProjectService {
    void saveProject(Project project);
    void deleteProject(Project project);
    Project getProject(Long id);
    List<Project> getAllProjects();
}