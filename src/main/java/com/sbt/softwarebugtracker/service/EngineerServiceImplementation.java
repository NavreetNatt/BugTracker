package com.sbt.softwarebugtracker.service;

import com.sbt.softwarebugtracker.dtos.Engineer.requests.DeleteEngineerRequestDto;
import com.sbt.softwarebugtracker.dtos.Engineer.requests.FetchAllEngineerRequestDto;
import com.sbt.softwarebugtracker.dtos.Engineer.requests.RegisterEngineerRequestDto;
import com.sbt.softwarebugtracker.dtos.Engineer.requests.UpdateEngineerRequestDto;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.DeleteEngineerResponseDto;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.FindEngineerByRoleResponseDto;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.RegisterEngineerResponseDto;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.UpdateEngineerResponseDto;
import com.sbt.softwarebugtracker.exceptions.Engineer.EngineerNotFoundException;
import com.sbt.softwarebugtracker.exceptions.Engineer.InvalidInputParamsException;
import com.sbt.softwarebugtracker.exceptions.SBTException;
import com.sbt.softwarebugtracker.model.Engineer;
import com.sbt.softwarebugtracker.model.EngineerRole;
import com.sbt.softwarebugtracker.repository.EngineerRepository;
import com.sbt.softwarebugtracker.utils.EngineerModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EngineerServiceImplementation implements EngineerService {
    @Autowired
    private EngineerRepository engineerRepository;

    @Override
    public RegisterEngineerResponseDto registerEngineer(RegisterEngineerRequestDto registerEngineerRequestDto) {
        Optional<Engineer> optionalEngineer = engineerRepository.findEngineerByEmail(registerEngineerRequestDto.getEmail());
        if (optionalEngineer.isPresent()) {
            throw new SBTException("This email address is already in use by another engineer, please use another");
        }
        Engineer engineer = EngineerModelMapper.registerEngineerMap(registerEngineerRequestDto);
        Engineer saveEngineer = engineerRepository.save(engineer);
        return EngineerModelMapper.registerEngineerMap(saveEngineer);
    }

    @Override
    public DeleteEngineerResponseDto deleteEngineer(DeleteEngineerRequestDto deleteEngineerRequestDto) {
        Optional<Engineer> optionalEngineer = engineerRepository.findEngineerByEmail(deleteEngineerRequestDto.getEmail());
        if (optionalEngineer.isEmpty()) {
            throw new EngineerNotFoundException("Engineer with email " + deleteEngineerRequestDto.getEmail() + " not found");
        }

        Engineer engineerToDelete = optionalEngineer.get();
        engineerRepository.delete(engineerToDelete);

        DeleteEngineerResponseDto deleteEngineerResponseDto = new DeleteEngineerResponseDto();
        deleteEngineerResponseDto.setMessage("Engineer with email " + deleteEngineerRequestDto.getEmail() + " deleted successfully");
        return deleteEngineerResponseDto;
    }

    @Override
    public UpdateEngineerResponseDto updateEngineer(UpdateEngineerRequestDto updateEngineerRequestDto, String engineerEmailAddress) {
        Optional<Engineer> optionalEngineer = engineerRepository.findEngineerByEmail(engineerEmailAddress);
        if (optionalEngineer.isEmpty()) {
            throw new EngineerNotFoundException("Engineer with email " + engineerEmailAddress + " not found");
        }

        Engineer engineerToUpdate = optionalEngineer.get();
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

        return null;
    }


//        return null;

    @Override
    public FindEngineerByRoleResponseDto findEngineerByRole(EngineerRole role) {
        Optional<Engineer> optionalEngineer = engineerRepository.findEngineerByRole(role);

        return null;
    }

    @Override
    public FetchAllEngineerRequestDto fetchAllEngineers(Engineer engineer) {
        return null;
    }

}
