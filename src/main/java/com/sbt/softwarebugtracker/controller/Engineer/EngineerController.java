package com.sbt.softwarebugtracker.controller.Engineer;

import com.sbt.softwarebugtracker.dtos.Engineer.requests.DeleteEngineerRequestDto;
import com.sbt.softwarebugtracker.dtos.Engineer.requests.RegisterEngineerRequestDto;
import com.sbt.softwarebugtracker.dtos.Engineer.responses.APIResponse;
import com.sbt.softwarebugtracker.exceptions.Engineer.EngineerNotFoundException;
import com.sbt.softwarebugtracker.exceptions.SBTException;
import com.sbt.softwarebugtracker.model.Engineer;
import com.sbt.softwarebugtracker.service.EngineerServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sbt/engineers")
public class EngineerController {
    @Autowired
    private EngineerServiceImplementation engineerServiceImplementation;

    @PostMapping("/register")
    public ResponseEntity<?> createNewEngineerAccount(@RequestBody RegisterEngineerRequestDto registerEngineerRequestDto) {
        try {
            APIResponse apiResponse = APIResponse.builder()
                    .message("id: " + engineerServiceImplementation.registerEngineer(registerEngineerRequestDto))
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } catch (SBTException sbtException) {
            APIResponse apiResponse = APIResponse.builder()
                    .message(sbtException.getMessage())
                    .isSuccessful(false)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEngineerAccount(@RequestBody DeleteEngineerRequestDto deleteEngineerRequestDto) {
        try {
            APIResponse apiResponse = APIResponse.builder()
                    .message("id: " + engineerServiceImplementation.deleteEngineer(deleteEngineerRequestDto))
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } catch (EngineerNotFoundException engineerNotFoundException) {
            APIResponse apiResponse = APIResponse.builder()
                    .message(engineerNotFoundException.getMessage())
                    .isSuccessful(false)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/engineers")
    public List<Engineer> fetchAllEngineers() {
        return engineerServiceImplementation.fetchAllEngineers();
    }
}

//    @GetMapping("/allContact")
//    public List<Contact> getAllContact(){
//        return service.getAllContacts();
//    }

//    @PatchMapping("/update")
//    public ResponseEntity<?> updateEngineerAccount(@RequestBody UpdateEngineerRequestDto updateEngineerRequestDto) {
//        try {
//            APIResponse apiResponse = APIResponse.builder()
//                    .message("id: " + engineerServiceImplementation.updateEngineer(updateEngineerRequestDto, updateEngineerRequestDto.getEmail()))
//                    .isSuccessful(true)
//                    .build();
//            return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);
//        } catch (EngineerNotFoundException engineerNotFoundException) {
//            APIResponse apiResponse = APIResponse.builder()
//                    .message(engineerNotFoundException.getMessage())
//                    .isSuccessful(false)
//                    .build();
//            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
//        }
//    }
