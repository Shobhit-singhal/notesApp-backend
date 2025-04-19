package com.shobhit.Backend.controller;

import com.shobhit.Backend.dto.UserResponseDTO;
import com.shobhit.Backend.entity.User;
import com.shobhit.Backend.repository.UserRepo;
import com.shobhit.Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/info")
    public UserResponseDTO getUserInfo(Authentication authentication){
        System.out.println("hi");
        return userService.getUserInfo(authentication.getName());
    }
}
