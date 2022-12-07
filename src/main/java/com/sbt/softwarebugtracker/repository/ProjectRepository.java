package com.sbt.softwarebugtracker.repository;

import com.sbt.softwarebugtracker.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
}
