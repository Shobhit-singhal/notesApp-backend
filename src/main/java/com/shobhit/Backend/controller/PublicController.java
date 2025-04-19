package com.shobhit.Backend.controller;

import com.shobhit.Backend.dto.LoginResponseDto;
import com.shobhit.Backend.dto.UserLoginReqDTO;
import com.shobhit.Backend.dto.UserRequestDTO;
import com.shobhit.Backend.dto.UserResponseDTO;
import com.shobhit.Backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserResponseDTO register(@Valid @RequestBody UserRequestDTO user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@Valid @RequestBody UserLoginReqDTO user){
        return userService.login(user);

    }
}
