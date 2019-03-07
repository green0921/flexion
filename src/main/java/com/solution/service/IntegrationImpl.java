package com.solution.service;

import com.flexionmobile.codingchallenge.integration.Integration;
import com.flexionmobile.codingchallenge.integration.Purchase;
import com.solution.domain.PurchaseEntity;
import com.solution.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntegrationImpl implements Integration {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private PurchaseTransformer purchaseTransformer;

    @Override
    public Purchase buy(String s) {
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setConsumed(false);
        purchaseEntity.setItemId(s);
        purchaseRepository.save(purchaseEntity);
        return purchaseTransformer.transformToPurchase(purchaseEntity);
    }

    @Override
    public List<Purchase> getPurchases() {
        List<PurchaseEntity> purchasesEntities = purchaseRepository.findAll();
        return purchaseTransformer.transformToPurchases(purchasesEntities);
    }

    @Override
    public void consume(Purchase purchase) {
        Optional<PurchaseEntity> purchaseEntity = purchaseRepository.findById(Integer.valueOf(purchase.getId()));
        if(purchaseEntity.isPresent()){
            purchaseEntity.get().setConsumed(true);
            purchaseRepository.save(purchaseEntity.get());
        }
    }
}
