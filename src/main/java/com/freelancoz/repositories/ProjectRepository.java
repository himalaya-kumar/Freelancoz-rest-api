package com.freelancoz.repositories;

import org.springframework.data.repository.CrudRepository;

import com.freelancoz.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{}