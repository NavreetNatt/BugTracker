package com.sbt.softwarebugtracker.dtos.Engineer.requests;

import com.sbt.softwarebugtracker.model.EngineerRole;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class UpdateEngineerRequestDto {
    @Email
    @Size(max = 50)
    private String email;
    @Size(max = 20)
    private String firstName;
    @Size(max = 20)
    private String lastName;
    @Size(min = 8, max = 120)
    private String password;
    private EngineerRole engineerRole;
}
