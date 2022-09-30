package com.sbt.softwarebugtracker.dtos.Engineer.requests;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class DeleteEngineerRequestDto {
    @Email
    @NotBlank
    @Size(max = 50)
    private String email;
}
