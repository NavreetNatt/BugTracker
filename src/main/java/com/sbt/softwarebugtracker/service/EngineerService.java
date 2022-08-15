package com.sbt.softwarebugtracker.service;

import com.sbt.softwarebugtracker.dtos.Engineer.requests.*;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.DeleteEngineerResponseDto;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.FindEngineerByRoleResponseDto;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.RegisterEngineerResponseDto;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.UpdateEngineerResponseDto;
import com.sbt.softwarebugtracker.model.Engineer;
import com.sbt.softwarebugtracker.model.EngineerRole;

public interface EngineerService {
    RegisterEngineerResponseDto registerEngineer(RegisterEngineerRequestDto registerEngineerRequestDto);
    DeleteEngineerResponseDto deleteEngineer(DeleteEngineerRequestDto deleteEngineerRequestDto);
    UpdateEngineerResponseDto updateEngineer(UpdateEngineerRequestDto updateEngineerRequestDto, String engineerEmailAddress);
    FindEngineerByRoleResponseDto findEngineerByRole(EngineerRole role);
    FetchAllEngineerRequestDto fetchAllEngineers(Engineer engineer);
}
