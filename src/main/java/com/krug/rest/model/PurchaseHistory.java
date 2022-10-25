package com.krug.rest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "purchase_history")
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id", nullable = false)
    private  Long userId;
    @Column(name = "poke_id", nullable = false)
    private Long pokeId;
    @Column(name = "price", nullable = false)
    private Double price;
}
