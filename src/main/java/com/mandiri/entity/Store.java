package com.mandiri.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mst_store")
public class Store {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

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

    public String getId() {
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