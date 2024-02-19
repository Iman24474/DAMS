package com.cs5800.dams.controller;

import com.cs5800.dams.entity.User;
import com.cs5800.dams.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String Home()
    {
        return "AdminDash";
    }

    @GetMapping("/AdminDash")
    public String adminDash()
    {
        return "AdminDash";
    }

    @GetMapping("/ManageAccounts")
    public String manageAccounts()
    {
        return "ManageAccounts";
    }

    @GetMapping("CreateAccounts")
    public String createAccounts()
    {
        return "CreateAccounts";
    }

    @GetMapping("/ManageDonations")
    public String manageDonations()
    {
        return "ManageDonations";
    }

    @PostMapping("/Save")
    public String addUser(@ModelAttribute User user)
    {
        userService.save(user);
        return "redirect:/ManageAccounts";
    }
}
