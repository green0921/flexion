package com.solution.web;

import com.flexionmobile.codingchallenge.integration.Integration;
import com.solution.service.DeveloperValidator;
import com.solution.web.exception.FailMessageException;
import com.solution.web.param.PurchaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumeController {
    private static final String REQUEST_MAPPING = "{developerId}/consume/{purchaseId}";

    @Autowired
    private DeveloperValidator developerValidator;
    @Autowired
    private Integration integration;

    @PostMapping(value = REQUEST_MAPPING)
    public void consume(@PathVariable("developerId") String developerId, @PathVariable("purchaseId") String purchaseId)
            throws FailMessageException {
        developerValidator.validateDeveloperId(developerId, "That's not right");
        PurchaseRequest purchaseRequest = new PurchaseRequest(purchaseId);
        integration.consume(purchaseRequest);
    }

}
