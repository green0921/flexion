package com.solution.service;

import com.flexionmobile.codingchallenge.integration.IntegrationTestRunner;
import com.solution.domain.PurchaseEntity;
import com.solution.repository.PurchaseRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

public class IntegrationImplTest {
    @Mock
    private PurchaseRepository purchaseRepository;
    @Spy
    private PurchaseTransformer purchaseTransformer;
    @InjectMocks
    private IntegrationTestRunner integrationTestRunner;
    @InjectMocks
    private LocalIntegration underTest;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIntegrationRunWithoutException() {
        //GIVEN
        List<PurchaseEntity> mockList = new ArrayList<>();
        PurchaseEntity mockPurchaseEntity = createMockPurchaseEntity(0, true, "item1");
        mockList.add(mockPurchaseEntity);
        Mockito.when(purchaseRepository.findAll()).thenReturn(mockList);
        //WHEN
        //THEN
        integrationTestRunner.runTests(underTest);
        Mockito.verify(purchaseRepository).findAll();
        Mockito.verify(purchaseRepository).findById(0);
    }

    private PurchaseEntity createMockPurchaseEntity(int id, boolean consumed, String itemId) {
        PurchaseEntity mockEntity = new PurchaseEntity();
        mockEntity.setId(id);
        mockEntity.setConsumed(consumed);
        mockEntity.setItemId(itemId);
        return mockEntity;
    }
}
