package com.shobhit.Backend.service;

import com.shobhit.Backend.repository.ToDoRepo;
import com.shobhit.Backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ToDoRepo toDoRepo;


}
