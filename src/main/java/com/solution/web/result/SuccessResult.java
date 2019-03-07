package com.solution.web.result;

import com.flexionmobile.codingchallenge.integration.Purchase;

import java.util.List;

public class SuccessResult{
    private List<Purchase> purchases;

    public SuccessResult(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }
}
