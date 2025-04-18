package com.shobhit.Backend.service;

import com.shobhit.Backend.entity.MyUserDetails;
import com.shobhit.Backend.entity.User;
import com.shobhit.Backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Username not found"));

        return new MyUserDetails(user);
    }
}
