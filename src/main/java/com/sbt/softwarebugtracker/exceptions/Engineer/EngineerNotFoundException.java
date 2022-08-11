package com.sbt.softwarebugtracker.exceptions.Engineer;

import com.sbt.softwarebugtracker.exceptions.SBTException;

public class EngineerNotFoundException extends SBTException {
    public EngineerNotFoundException(String message) {
        super(message);
    }
}
