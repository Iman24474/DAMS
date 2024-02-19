package com.cs5800.dams.controller;

import com.cs5800.dams.entity.User;
import com.cs5800.dams.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String Home()
    {
        return "AdminDash";
    }

    @GetMapping("admin_dash")
    public String adminDash()
    {
        return "AdminDash";
    }

    @GetMapping("/manage_accounts")
    public ModelAndView manageAccounts()
    {
        List<User> list = userService.getAllUsers();
        return new ModelAndView("ManageAccounts", "user", list);
    }

    @GetMapping("create_accounts")
    public String createAccounts()
    {
        return "CreateAccounts";
    }

    @GetMapping("manage_donations")
    public String manageDonations()
    {
        return "ManageDonations";
    }

    @PostMapping("/Save")
    public String addUser(@ModelAttribute User user)
    {
        userService.save(user);
        return "redirect:/manage_accounts";
    }

    @GetMapping("edit_accounts")
    public String editAccounts()
    {
        return "EditAccounts";
    }
}
