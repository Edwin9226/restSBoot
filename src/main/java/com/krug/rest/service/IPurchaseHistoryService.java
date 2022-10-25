package com.krug.rest.service;

import com.krug.rest.model.PurchaseHistory;
import com.krug.rest.repositry.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {


    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchasedItemOfUser(Long userId);
}
