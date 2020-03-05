package com.freelancoz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelancoz.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{}