package com.shobhit.Backend.service;

import com.shobhit.Backend.dto.LoginResponseDto;
import com.shobhit.Backend.dto.UserLoginReqDTO;
import com.shobhit.Backend.dto.UserRequestDTO;
import com.shobhit.Backend.dto.UserResponseDTO;
import com.shobhit.Backend.entity.User;
import com.shobhit.Backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtService jwtService;


    public UserResponseDTO register(UserRequestDTO user) {
        user.setPassword(encoder.encode((user.getPassword())));
        User user1=User.builder().username(user.getUsername()).password(user.getPassword()).gender(user.getGender()).build();
        User savedUser = userRepo.save(user1);
        return UserResponseDTO.builder().username(savedUser.getUsername()).gender(savedUser.getGender()).build();
    }

    public LoginResponseDto login(UserLoginReqDTO user) {
        Authentication authentication=
                manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        String token= jwtService.generateToken(user.getUsername());
        return LoginResponseDto.builder().token(token).build();
    }
}
