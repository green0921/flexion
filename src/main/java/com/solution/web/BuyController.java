package com.solution.web;

import com.flexionmobile.codingchallenge.integration.Integration;
import com.flexionmobile.codingchallenge.integration.Purchase;
import com.solution.service.DeveloperValidator;
import com.solution.web.exception.FailMessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BuyController {
    private static final String REQUEST_MAPPING = "{developerId}/buy/{itemId}";

    @Autowired
    private DeveloperValidator developerValidator;
    @Autowired
    private Integration integration;

    @PostMapping(value = REQUEST_MAPPING, produces = "application/json")
    public Purchase buy(@PathVariable("developerId") String developerId, @PathVariable("itemId") String itemId)
            throws FailMessageException {
        developerValidator.validateDeveloperId(developerId);
        return integration.buy(itemId);
    }
}
