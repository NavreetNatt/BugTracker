package com.sbt.softwarebugtracker.dtos.Engineer.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class APIResponse {
    private boolean isSuccessful;
    private String message;
}
