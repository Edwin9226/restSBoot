package com.krug.rest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "purchase_history")
public class PurchaseHistory extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id", nullable = false)
    private  Long userId;
    @Column(name = "book_id", nullable = false)
    private Long bookId;
    @Column(name = "price", nullable = false)
    private Double price;
}
