package com.krug.rest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "description", nullable = false, length = 1000)
    private  String description;
    @Column(name = "author", nullable = false, length = 100)
    private String author;
    @Column(name = "price", nullable = false)
    private Double price;


}
