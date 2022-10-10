package com.sbt.softwarebugtracker.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NonNull
public class TeamLead {
    @Id
    @Size(max = 50)
    @Email
    @NotNull(message = "A valid email address is required")
    private String email;
    @Size(max = 20)
    private String firstName;
    @Size(max = 20)
    private String lastName;
    @Size(max = 120)
    private String password;
}
