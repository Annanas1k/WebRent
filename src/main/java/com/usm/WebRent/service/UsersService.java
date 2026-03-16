package com.usm.WebRent.service;

import com.usm.WebRent.entity.Users;

import java.util.List;

public interface UsersService {
    Users save(Users users);
    List<Users> findAll();
    Users findById(Long id);
    Users update(Long id, Users users);
    void deleteById(Long id);

    Users findByEmail(String email);
}
