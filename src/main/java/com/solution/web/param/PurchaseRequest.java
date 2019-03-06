package com.solution.web.param;

import com.flexionmobile.codingchallenge.integration.Purchase;

public class PurchaseRequest implements Purchase {
    private final String id;
    private final boolean consumed;
    private final String itemId;

    public PurchaseRequest(String id) {
        this.id = id;
        this.consumed = true;
        this.itemId = "";
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public boolean getConsumed() {
        return this.consumed;
    }

    @Override
    public String getItemId() {
        return this.itemId;
    }
}
