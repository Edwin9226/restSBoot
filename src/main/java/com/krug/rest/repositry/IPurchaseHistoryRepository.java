package com.krug.rest.repositry;

import com.krug.rest.model.PurchaseHistory;
import com.krug.rest.repositry.projection.IPurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {
    @Query("select "+
            "b.title as title, ph.price as price"
            +" from PurchaseHistory ph left join Book b on b.id=ph.bookId"+
            "where ph.userId= :userId")
    List<IPurchaseItem> finAllPurchasesOfUser(@Param("userId") Long userId);
}
