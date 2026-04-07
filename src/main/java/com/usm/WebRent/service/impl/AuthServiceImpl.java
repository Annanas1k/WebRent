package com.usm.WebRent.service.impl;

import com.usm.WebRent.entity.Users;
import com.usm.WebRent.entity.enums.UserStatus;
import com.usm.WebRent.service.AuthService;
import com.usm.WebRent.service.UsersService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UsersService usersService;

    @Override
    public String login(String email, String password, HttpSession session) {
        Users user = usersService.findByEmail(email);

        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }

        session.setAttribute("loggedUser", user);
        session.setAttribute("userRole", user.getStatus().name());
        return user.getStatus() == UserStatus.ADMIN ? "redirect:/admin/dashboard" : "redirect:/admin";
    }

    @Override
    public boolean register(Users user) {
        if (usersService.findByEmail(user.getEmail()) != null) {
            return false;
        }

        user.setStatus(UserStatus.CUSTOMER);
        user.setCreatedAt(java.time.LocalDateTime.now());
        usersService.save(user);
        return true;
    }
}