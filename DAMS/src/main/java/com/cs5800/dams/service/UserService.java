package com.cs5800.dams.service;

import com.cs5800.dams.entity.User;
import com.cs5800.dams.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void save(User user)
    {
        userRepository.save(user);
    }
}
