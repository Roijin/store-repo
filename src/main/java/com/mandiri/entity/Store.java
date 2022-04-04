package com.mandiri.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mst_store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Missing Store Name")
    private String name;

    @NotNull(message = "Missing Store Address")
    private String address;

    @NotNull(message = "Missing Store Phone Number")
    private String phoneNumber;

    @NotNull(message = "Missing Store SIUP")
    private String siup;

    @NotNull(message = "Missing Store NPWP")
    private String npwp;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSiup() {
        return siup;
    }

    public String getNpwp() {
        return npwp;
    }
}