package com.usm.WebRent.controller;

import com.usm.WebRent.entity.Users;
import com.usm.WebRent.service.AuthService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        String redirect = authService.login(email, password, session);
        if (redirect == null) {
            model.addAttribute("error", "Email or password incorect !");
            return "auth/login";
        }
        return redirect;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new Users());
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Users user, Model model) {
        if (!authService.register(user)) {
            model.addAttribute("error", "Email-ul este deja folosit!");
            return "auth/register";
        }
        return "redirect:/login?registered";
    }
}