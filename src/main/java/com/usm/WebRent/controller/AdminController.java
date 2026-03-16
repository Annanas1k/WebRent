package com.usm.WebRent.controller;

import com.usm.WebRent.entity.Car;
import com.usm.WebRent.entity.Users;
import com.usm.WebRent.service.CarService;
import com.usm.WebRent.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UsersService usersService;
    private final CarService carService;
    private final PasswordEncoder passwordEncoder;


    // Rulează automat înainte de orice metodă — adaugă userul logat în model
    @ModelAttribute
    public void addLoggedUser(Model model, Authentication authentication) {
        if (authentication != null) {
            Users user = usersService.findByEmail(authentication.getName());
            model.addAttribute("loggedUser", user);
        }
    }

    @GetMapping({"", "/"})
    public String adminRoot() {
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "admin/dashboard";
    }

//  ==========  USERS CRUD  =================

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", usersService.findAll());
        return "admin/users";
    }

    @GetMapping("/users/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new Users());
        return "admin/user-form";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", usersService.findById(id));
        return "admin/user-form";
    }

    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        usersService.deleteById(id);
        return "redirect:/admin/users";
    }

    //  ==========  CAR CRUD  =================

    @GetMapping("/cars")
    public String listCars(Model model){
        model.addAttribute("cars", carService.findAll());
        return "admin/cars";
    }
}