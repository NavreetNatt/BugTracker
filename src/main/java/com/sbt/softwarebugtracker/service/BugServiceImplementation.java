package com.sbt.softwarebugtracker.service;

import com.sbt.softwarebugtracker.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BugServiceImplementation implements BugService {
    @Autowired
    private BugRepository bugRepository;

}
