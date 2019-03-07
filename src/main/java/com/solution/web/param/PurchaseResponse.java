package com.solution.web.param;

import com.flexionmobile.codingchallenge.integration.Purchase;

public class PurchaseResponse implements Purchase {
    private final String id;
    private final boolean consumed;
    private final String itemId;

    public PurchaseResponse(String id, boolean consumed, String itemId) {
        this.id = id;
        this.consumed = consumed;
        this.itemId = itemId;
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
