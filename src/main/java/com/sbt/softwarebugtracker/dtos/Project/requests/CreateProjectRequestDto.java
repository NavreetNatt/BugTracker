package com.sbt.softwarebugtracker.dtos.Project.requests;

import com.sbt.softwarebugtracker.model.ProjectStatus;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NonNull
@NotNull
@Data
public class CreateProjectRequestDto {
    public String projectName;
    private String projectOverview;
    private ProjectStatus projectStatus;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
