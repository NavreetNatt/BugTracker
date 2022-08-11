package com.sbt.softwarebugtracker.exceptions.Engineer;

import com.sbt.softwarebugtracker.exceptions.SBTException;

public class InvalidInputParamsException extends SBTException {
    public InvalidInputParamsException(String message) {
        super(message);
    }
}
