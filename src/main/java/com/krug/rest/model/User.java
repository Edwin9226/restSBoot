package com.krug.rest.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Edwin Pinchao
 * @date 13.10.2022
 * @Time 05:00
 */
@Data
@Entity
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;
    @Column(name = "password",  nullable = false, length = 100)
    private String password;
    @Column(name = "name",  nullable = false, length = 100)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false )
    private Rol role;

    @Transient
    private String token;

}
