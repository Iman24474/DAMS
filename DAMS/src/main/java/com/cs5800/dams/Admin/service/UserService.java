package com.cs5800.dams.Admin.service;

import com.cs5800.dams.Admin.entity.User;
import com.cs5800.dams.Admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void save(User user)
    {
        // Check if the username is unique
        if (userRepository.findByUsername(user.getUsername()) != null && userRepository.findByUsername(user.getUsername()).getId() != user.getId()) {
            throw new RuntimeException("Username already exists. Please choose a different username.");
        }
        // Check if the email is unique
        if (userRepository.findByEmail(user.getEmail()) != null && userRepository.findByEmail(user.getEmail()).getId() != user.getId()) {
            throw new RuntimeException("Email already exists. Please use a different email address.");
        }
        userRepository.save(user);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public void deleteById(int id)
    {
        userRepository.deleteById(id);
    }

    public User getUserById(int id)
    {
        return userRepository.findById(id).get();
    }

    public User getUserByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    public User getUserByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }
}
