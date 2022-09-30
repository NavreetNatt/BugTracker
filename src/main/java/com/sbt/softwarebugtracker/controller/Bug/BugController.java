package com.sbt.softwarebugtracker.controller.Bug;

import com.sbt.softwarebugtracker.repository.BugRepository;
import com.sbt.softwarebugtracker.service.BugServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sbt/projects/bugs")
public class BugController {

    @Autowired
    private BugServiceImplementation bugServiceImplementation;
}
