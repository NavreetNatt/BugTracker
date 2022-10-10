package com.sbt.softwarebugtracker.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Bug {
    private BugPriority priority;
    private BugSeverity severity;
    private StackLocation location;
    private String ticketTitle;
    private String ticketDescription;
    private Engineer assignedEngineer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Project project;
}
