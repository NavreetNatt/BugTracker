package com.sbt.softwarebugtracker.utils;

import com.sbt.softwarebugtracker.dtos.Engineer.requests.RegisterEngineerRequestDto;
import com.sbt.softwarebugtracker.dtos.Engineer.requests.UpdateEngineerRequestDto;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.RegisterEngineerResponseDto;
import com.sbt.softwarebugtracker.model.Engineer;

public class EngineerModelMapper {
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

    public static Engineer updateEngineerMap(UpdateEngineerRequestDto updateEngineerRequestDto){

        return null;
    }

 }
