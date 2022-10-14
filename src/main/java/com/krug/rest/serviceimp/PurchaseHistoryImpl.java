package com.krug.rest.serviceimp;

import com.krug.rest.model.PurchaseHistory;
import com.krug.rest.repositry.IPurchaseHistoryRepository;
import com.krug.rest.repositry.projection.IPurchaseItem;
import com.krug.rest.service.IPurchaseHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseHistoryImpl {

    private final IPurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistoryImpl(IPurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        return purchaseHistoryRepository.save(purchaseHistory);
    }
    public List<IPurchaseItem> findPurchasedItemOfUser(Long userId)
    {
        return purchaseHistoryRepository.finAllPurchasesOfUser(userId);
    }
}
