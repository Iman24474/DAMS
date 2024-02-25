package com.cs5800.dams.Admin.controller;

import com.cs5800.dams.Admin.entity.Donation;
import com.cs5800.dams.Admin.entity.User;
import com.cs5800.dams.Admin.service.DonationService;
import com.cs5800.dams.Admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private DonationService donationService;

    //Admin Dashboard main page
//    @GetMapping("/")
//    public String Home()
//    {
//        return "/Admin/AdminDash";
//    }

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

//    @GetMapping("create_accounts")
//    public String createAccounts()
//    {
//        return "Admin/Accounts/CreateAccounts";
//    }
    @GetMapping("create_accounts")
    public String createAccounts(Model model)
    {
        model.addAttribute("user", new User());
        return "Admin/Accounts/CreateAccounts";
    }

//    @GetMapping("create_accounts")
//    public String showPassword(Model model, @RequestParam(defaultValue = "false") boolean showPassword)
//    {
//
//        // Add the showPassword attribute to the model
//        model.addAttribute("showPassword", showPassword);
//        return "Admin/Accounts/CreateAccounts";
//    }


    @PostMapping("/saveUser")
    public String addUser(@ModelAttribute User user, Model model)
    {
        try
        {
            //Encrypt the password
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userService.save(user);
            return "redirect:/manage_accounts";
        }
        catch (RuntimeException e)
        {
            // Handle the exception by adding an error message to the model
            model.addAttribute("error", e.getMessage());
            model.addAttribute("user", user); // to repopulate the form with user data
            return "Admin/Accounts/CreateAccounts";
        }

    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id)
    {
        userService.deleteById(id);
        return ("redirect:/manage_accounts");
    }

    @RequestMapping("/editUser/{id}")
    public String editAccounts(@PathVariable("id") int id, Model model)
    {

        User temp = userService.getUserById(id);
        model.addAttribute("tempUser", temp);
        return "Admin/Accounts/EditAccounts";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute User updatedUser, Model model) {
        try {
            // Check if the updated username & email is unique (excluding the current user)
            User existingUserByUsername = userService.getUserByUsername(updatedUser.getUsername());
            User existingUserByEmail = userService.getUserByEmail(updatedUser.getEmail());
            if (existingUserByUsername != null && existingUserByUsername.getId() != id) {
                throw new RuntimeException("Username already exists. Please choose a different username.");
            }

            if (existingUserByEmail != null && existingUserByEmail.getId() != id) {
                throw new RuntimeException("E-mail already exists. Please choose a different E-mail.");
            }

            // Proceed with updating the user
            User currentUser = userService.getUserById(id);
            currentUser.setFirstName(updatedUser.getFirstName());
            currentUser.setLastName(updatedUser.getLastName());
            currentUser.setEmail(updatedUser.getEmail());
            currentUser.setUsername(updatedUser.getUsername());
            currentUser.setPassword(updatedUser.getPassword());
            currentUser.setAddress(updatedUser.getAddress());
            currentUser.setCity(updatedUser.getCity());
            currentUser.setState(updatedUser.getState());
            currentUser.setZipCode(updatedUser.getZipCode());
            currentUser.setRole(updatedUser.getRole());

            userService.save(currentUser);
            return "redirect:/manage_accounts";
        } catch (RuntimeException e) {
            // Handle the exception by adding an error message to the model
            model.addAttribute("error", e.getMessage());
            model.addAttribute("tempUser", updatedUser); // to repopulate the form with user data
            return "Admin/Accounts/EditAccounts";
        }
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

    @RequestMapping("/deleteDonation/{id}")
    public String deleteDonation(@PathVariable("id") int id)
    {
        donationService.deleteById(id);
        return "redirect:/manage_donations";
    }
}
