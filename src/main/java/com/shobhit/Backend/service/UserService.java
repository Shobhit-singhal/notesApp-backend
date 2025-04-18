package com.shobhit.Backend.service;

import com.shobhit.Backend.entity.User;
import com.shobhit.Backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User register(User user) {
        return user;
    }

    public String login(User user) {
        return "Success";
    }
}
