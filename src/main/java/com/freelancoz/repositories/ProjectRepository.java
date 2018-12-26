package com.freelancoz.repositories;

import com.freelancoz.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>{
 //   List<Project> findByProjectId(long id);
}