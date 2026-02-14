package com.usm.WebRent.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;
    private String city;
    private String phone;
    private String workingHouse;

    public Location() {}

    public Location(Long id, String address, String city, String phone, String workingHouse) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.workingHouse = workingHouse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkingHouse() {
        return workingHouse;
    }

    public void setWorkingHouse(String workingHouse) {
        this.workingHouse = workingHouse;
    }
}
