package com.sbt.softwarebugtracker.service;

import com.sbt.softwarebugtracker.dtos.Bug.requests.CreateBugReportRequestDto;
import com.sbt.softwarebugtracker.dtos.Bug.requests.DeleteBugReportRequestDto;
import com.sbt.softwarebugtracker.dtos.Bug.responses.CreateBugReportResponseDto;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.DeleteEngineerResponseDto;
import com.sbt.softwarebugtracker.model.Bug;
import com.sbt.softwarebugtracker.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BugServiceImplementation implements BugService {
    @Autowired
    private BugRepository bugRepository;

    @Override
    public CreateBugReportResponseDto createBugReport(CreateBugReportRequestDto createBugReportRequestDto) {
        return null;
    }

    @Override
    public DeleteEngineerResponseDto deleteBugReport(DeleteBugReportRequestDto deleteBugReportRequestDto) {
        return null;
    }


    @Override
    public List<Bug> fetchAllOpenBugTickets() {
        return null;
    }
}
