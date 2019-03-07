package com.solution.service;

import com.solution.web.exception.FailMessageException;
import org.springframework.stereotype.Service;

@Service
public class DeveloperValidator {
    public void validateDeveloperId(String developerId) throws FailMessageException{
        if(!developerId.equals("batman")) {
            throw new FailMessageException();
        }
    }

    public void validateDeveloperId(String developerId, String message) throws FailMessageException{
        if(!developerId.equals("batman")) {
            throw new FailMessageException(message);
        }
    }
}
