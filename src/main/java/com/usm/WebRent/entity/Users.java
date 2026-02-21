package com.usm.WebRent.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor 
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String driverLicenseNumber;
    private LocalDateTime createdAt;

    public Users(Long id, String firstName, String lastName, String email, String phone, String password, String driverLicenseNumber, LocalDateTime createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.driverLicenseNumber = driverLicenseNumber;
        this.createdAt = createdAt;
    }
}