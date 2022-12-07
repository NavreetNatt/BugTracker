package com.sbt.softwarebugtracker.service;

import com.sbt.softwarebugtracker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImplementation implements ProjectService{
    @Autowired
    private ProjectRepository projectRepository;
}
