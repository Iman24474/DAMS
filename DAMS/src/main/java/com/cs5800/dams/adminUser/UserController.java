package com.cs5800.dams.adminUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired private UserService service;

    @GetMapping("/accounts")
    public String showAccountsList(Model model)
    {
        List<User> listAccounts = service.listAll();
        model.addAttribute("listAccounts", listAccounts);
        return "accounts";
    }

    @GetMapping("/accounts/new")
    public String showNewForm(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add New User");
        return "user_form";
    }

    @PostMapping("/accounts/save")
    public String saveAccount(User user, RedirectAttributes redirectAttributes)
    {
        service.save(user);
        redirectAttributes.addFlashAttribute("message", "The account has been saved successfully.");
        return "redirect:/accounts";
    }

    @GetMapping("/accounts/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes)
    {
        try
        {
            User user = service.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User (ID: " + id + ")");
            return "user_form";
        }
        catch (UserNotFoundException e)
        {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/accounts";
        }
    }

    @GetMapping("/accounts/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes)
    {
        try
        {
            service.delete(id);
            redirectAttributes.addFlashAttribute("message", "The user ID " + id + " has been deleted.");
        }
        catch (UserNotFoundException e)
        {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/accounts";
    }

}
