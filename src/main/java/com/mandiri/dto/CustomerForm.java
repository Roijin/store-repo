package com.mandiri.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class CustomerForm implements Serializable {
    private final String name;
    private final String username;
    private final LocalDate birthDate;
    private final String phoneNumber;
    private final String email;
    private final String gender;

    public CustomerForm(String name, String username, LocalDate birthDate, String phoneNumber, String email, String gender) {
        this.name = name;
        this.username = username;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
}
