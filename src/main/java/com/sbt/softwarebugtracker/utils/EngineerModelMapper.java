package com.sbt.softwarebugtracker.utils;

import com.sbt.softwarebugtracker.dtos.Engineer.requests.DeleteEngineerRequestDto;
import com.sbt.softwarebugtracker.dtos.Engineer.requests.RegisterEngineerRequestDto;
import com.sbt.softwarebugtracker.dtos.Engineer.requests.UpdateEngineerRequestDto;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.DeleteEngineerResponseDto;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.RegisterEngineerResponseDto;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.UpdateEngineerResponseDto;
import com.sbt.softwarebugtracker.exceptions.Engineer.InvalidInputParamsException;
import com.sbt.softwarebugtracker.model.Engineer;
import com.sbt.softwarebugtracker.model.EngineerRole;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import static com.sbt.softwarebugtracker.model.EngineerRole.*;

public class EngineerModelMapper {
    private static final Set<EngineerRole> ENGINEER_ROLES = Collections.unmodifiableSet(EnumSet.of(FRONTEND, BACKEND, FULLSTACK, QUALITY_ASSURANCE,DEVOPS));
    public static Engineer registerEngineerMap(RegisterEngineerRequestDto registerEngineerDto){
        Engineer engineer = new Engineer();
        engineer.setEmail(registerEngineerDto.getEmail());
        engineer.setFirstName(registerEngineerDto.getFirstName());
        engineer.setLastName(registerEngineerDto.getLastName());
        engineer.setPassword(registerEngineerDto.getPassword());
        engineer.setEngineerRole(registerEngineerDto.getEngineerRole());
        return engineer;
    }

    public static RegisterEngineerResponseDto registerEngineerMap(Engineer engineer) {
        RegisterEngineerResponseDto registerEngineerResponseDto = new RegisterEngineerResponseDto();
        registerEngineerResponseDto.setDetails("Welcome to SBT " + engineer.getFirstName());
        registerEngineerResponseDto.setMessage("An account confirmation email has been sent to " + engineer.getEmail());
        return registerEngineerResponseDto;
    }
    public static DeleteEngineerResponseDto deleteEngineerResponseDto(DeleteEngineerRequestDto deleteEngineerRequestDto) {
        DeleteEngineerResponseDto deleteEngineerResponseDto = new DeleteEngineerResponseDto();
        deleteEngineerResponseDto.setMessage("Engineer with email " + deleteEngineerRequestDto.getEmail() + " deleted successfully");
        return deleteEngineerResponseDto;
    }

    public static Engineer updateEngineerDetailsMap(UpdateEngineerRequestDto updateEngineerRequestDto, Engineer engineerToUpdate){
        if (!(updateEngineerRequestDto.getEmail() == null || updateEngineerRequestDto.getEmail().trim().equals(""))) {
            engineerToUpdate.setEmail(updateEngineerRequestDto.getEmail());
        } else {
            throw new InvalidInputParamsException("Please provide a valid email address");
        }

        if (!(updateEngineerRequestDto.getFirstName() == null || updateEngineerRequestDto.getFirstName().trim().equals(""))) {
            engineerToUpdate.setFirstName(updateEngineerRequestDto.getFirstName());
        } else {
            throw new InvalidInputParamsException("Enter a name");
        }

        if (!(updateEngineerRequestDto.getLastName() == null || updateEngineerRequestDto.getLastName().trim().equals(""))) {
            engineerToUpdate.setLastName(updateEngineerRequestDto.getLastName());
        } else {
            throw new InvalidInputParamsException("Enter a name");
        }

        if (!(updateEngineerRequestDto.getPassword() == null || updateEngineerRequestDto.getPassword().trim().equals(""))) {
            engineerToUpdate.setPassword(updateEngineerRequestDto.getPassword());
        } else {
            throw new InvalidInputParamsException("Please enter a valid password");
        }

        if (ENGINEER_ROLES.contains(updateEngineerRequestDto.getEngineerRole())){
            engineerToUpdate.setEngineerRole(updateEngineerRequestDto.getEngineerRole());
        } else {
            throw new InvalidInputParamsException("Please enter a developer role");
        }
        return engineerToUpdate;
    }

    public static UpdateEngineerResponseDto updateEngineerDetailsMap(Engineer engineer){
        UpdateEngineerResponseDto updateEngineerResponseDto  = new UpdateEngineerResponseDto();
        updateEngineerResponseDto.setDetails("Account details for " + engineer.getFirstName() + " have been updated successfully");
        return updateEngineerResponseDto;
    }
 }
