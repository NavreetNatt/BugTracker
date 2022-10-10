package com.sbt.softwarebugtracker.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Project {
    public String projectName;
    private String projectOverview;
    private ProjectStatus projectStatus;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
