package com.solution.web;

import com.flexionmobile.codingchallenge.integration.Integration;
import com.solution.service.DeveloperValidator;
import com.solution.web.exception.FailMessageException;
import com.solution.web.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAllController {
    private static final String REQUEST_MAPPING = "{developerId}/all";

    @Autowired
    private DeveloperValidator developerValidator;
    @Autowired
    private Integration integration;

    @GetMapping(value = REQUEST_MAPPING, produces = "application/json")
    public SuccessResult getAll(@PathVariable("developerId") String developerId) throws FailMessageException {
        developerValidator.validateDeveloperId(developerId);
        return new SuccessResult(integration.getPurchases());
    }
}
