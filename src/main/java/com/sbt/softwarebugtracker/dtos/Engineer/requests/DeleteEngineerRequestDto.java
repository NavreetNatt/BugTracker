package com.sbt.softwarebugtracker.dtos.Engineer.requests;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class DeleteEngineerRequestDto {
    @Email
    @Size(max = 50)
    private String email;
}
