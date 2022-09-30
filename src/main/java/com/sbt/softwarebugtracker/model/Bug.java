package com.sbt.softwarebugtracker.model;

import java.time.LocalDateTime;

public class Bug {
    private BugPriority priority;
    private BugSeverity severity;
    private StackLocation location;
    private String ticketTitle;
    private String ticketDescription;
    private Engineer assignedEngineer;
    private Status status;
    private boolean isResolved = false;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
