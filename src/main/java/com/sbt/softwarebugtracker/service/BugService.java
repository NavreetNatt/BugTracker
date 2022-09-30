package com.sbt.softwarebugtracker.service;

import com.sbt.softwarebugtracker.dtos.Bug.requests.CreateBugReportRequestDto;
import com.sbt.softwarebugtracker.dtos.Bug.requests.DeleteBugReportRequestDto;
import com.sbt.softwarebugtracker.dtos.Bug.responses.CreateBugReportResponseDto;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.DeleteEngineerResponseDto;
import com.sbt.softwarebugtracker.model.Bug;
import com.sbt.softwarebugtracker.model.Engineer;

import java.util.List;

public interface BugService {
    CreateBugReportResponseDto createBugReport(CreateBugReportRequestDto createBugReportRequestDto);
    DeleteEngineerResponseDto deleteBugReport(DeleteBugReportRequestDto deleteBugReportRequestDto);

    List<Bug> fetchAllOpenBugTickets();
}
