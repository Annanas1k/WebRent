package com.usm.WebRent.controller;

import com.usm.WebRent.entity.Users;
import com.usm.WebRent.entity.enums.UserStatus;
import com.usm.WebRent.service.UsersService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UsersService usersService;
    private final PasswordEncoder passwordEncoder;


    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model){

        Users user = usersService.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            model.addAttribute("error", "Email or password incorect !");
            return "auth/login";
        }

        session.setAttribute("loggedUser", user);
        session.setAttribute("userRole", user.getStatus().name());

        if (user.getStatus() == UserStatus.ADMIN) {
            return "redirect:/admin/dashboard";
        }
        return "redirect:/admin";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
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
        if (usersService.findByEmail(user.getEmail()) != null) {
            model.addAttribute("error", "Email-ul este deja folosit!");
            return "auth/register";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(UserStatus.CUSTOMER);
        user.setCreatedAt(java.time.LocalDateTime.now());

        usersService.save(user);
        return "redirect:/login?registered";
    }


}
