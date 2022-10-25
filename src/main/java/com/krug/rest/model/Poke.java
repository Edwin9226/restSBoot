package com.krug.rest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "poke")
public class Poke {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "description", nullable = false, length = 1000)
    private  String description;
    @Column(name = "type", nullable = false, length = 100)
    private String type;
    @Column(name = "power", nullable = false)
    private Double power;
}
