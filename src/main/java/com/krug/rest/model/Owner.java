package com.krug.rest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "owner")
@Data
public class Owner extends AuditModel {
    /**
     *
     @GeneratedValue(generator = "seq_owner")
     @SequenceGenerator(name = "seq_owner", sequenceName = "DB_SEQ_OWNER",allocationSize = 1)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ownerid;
    private String firstName, lastName;

    public Owner() {}

    public Owner(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
