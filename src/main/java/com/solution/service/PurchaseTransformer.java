package com.solution.service;

import com.flexionmobile.codingchallenge.integration.Purchase;
import com.solution.domain.PurchaseEntity;
import com.solution.web.param.PurchaseResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseTransformer {

    public Purchase transformToPurchase(PurchaseEntity purchaseEntity) {
        return new PurchaseResponse(
                String.valueOf(purchaseEntity.getId()),
                purchaseEntity.isConsumed(),
                purchaseEntity.getItemId());
    }

    public List<Purchase> transformToPurchases(List<PurchaseEntity> purchaseEntities) {
        List<Purchase> purchases = new ArrayList<>();
        for(PurchaseEntity purchaseEntity: purchaseEntities) {
            purchases.add(transformToPurchase(purchaseEntity));
        }
        return purchases;
    }
}
