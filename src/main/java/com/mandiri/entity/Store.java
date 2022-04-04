package com.mandiri.entity;

import javax.persistence.*;

@Entity
@Table(name = "mst_store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;
    private String address;
    private String siup;
    private String npwp;


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getSiup() {
        return siup;
    }

    public String getNpwp() {
        return npwp;
    }
}