package com.usm.WebRent.service;

import com.usm.WebRent.entity.Users;
import jakarta.servlet.http.HttpSession;

public interface AuthService {
    String login(String email, String password, HttpSession session);
    boolean register(Users user);
}