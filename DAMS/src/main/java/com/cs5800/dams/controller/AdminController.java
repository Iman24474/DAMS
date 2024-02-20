package com.cs5800.dams.controller;

import com.cs5800.dams.entity.Donation;
import com.cs5800.dams.entity.User;
import com.cs5800.dams.service.DonationService;
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
    @Autowired
    private DonationService donationService;

    //Admin Dashboard main page
    @GetMapping("/")
    public String Home()
    {
        return "/Admin/AdminDash";
    }

    @GetMapping("admin_dash")
    public String adminDash()
    {
        return "/Admin/AdminDash";
    }


    //Admin Dashboard accounts
    @GetMapping("/manage_accounts")
    public ModelAndView manageAccounts()
    {
        List<User> list = userService.getAllUsers();
        return new ModelAndView("Admin/Accounts/ManageAccounts", "user", list);
    }

    @GetMapping("create_accounts")
    public String createAccounts()
    {
        return "Admin/Accounts/CreateAccounts";
    }


    @PostMapping("/saveUser")
    public String addUser(@ModelAttribute User user)
    {
        userService.save(user);
        return "redirect:/manage_accounts";
    }

    @GetMapping("edit_accounts")
    public String editAccounts()
    {
        return "Admin/Accounts/EditAccounts";
    }


    //Admin Dashboard donations
    @GetMapping("manage_donations")
    public ModelAndView manageDonations()
    {
        List<Donation> list = donationService.getAllDonations();
        return new ModelAndView("Admin/Donations/ManageDonations", "donation", list);
    }

    @GetMapping("create_donations")
    public String createDonations()
    {
        return "Admin/Donations/CreateDonations";
    }

    @PostMapping("/saveDonation")
    public String addDonation(@ModelAttribute Donation donation)
    {
        donationService.save(donation);
        return "redirect:/manage_donations";
    }
}
