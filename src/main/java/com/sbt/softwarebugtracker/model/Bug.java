package com.sbt.softwarebugtracker.model;

public class Bug {
    private BugPriority priority;
    private BugSeverity severity;
    private StackLocation location;
    private String comments;
    private Engineer assignedEngineer;
    private Project project;
    private boolean isResolved = false;
}
