package com.krug.rest.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "users")
public class User extends AuditModel {
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
