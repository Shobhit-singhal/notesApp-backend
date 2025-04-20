package com.shobhit.Backend.service;

import com.shobhit.Backend.dto.TodoReqDTO;
import com.shobhit.Backend.dto.TodoResDTO;
import com.shobhit.Backend.entity.ToDo;
import com.shobhit.Backend.entity.User;
import com.shobhit.Backend.repository.ToDoRepo;
import com.shobhit.Backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ToDoRepo toDoRepo;


    public TodoResDTO addToDo(String name, TodoReqDTO todo) {
        User user=userRepo.findByUsername(name)
                .orElseThrow(()->new UsernameNotFoundException("No such user"));
        ToDo newToDo= ToDo.builder()
                .task(todo.getTask())
                .user(user)
                .isCompleted(false)
                .build();
        ToDo saved=toDoRepo.save(newToDo);
        user.getTodos().add(newToDo);
        return TodoResDTO.builder()
                .id(saved.getId())
                .task(saved.getTask())
                .isCompleted(saved.isCompleted())
                .build();
    }

    public List<TodoResDTO> getALl(String name) {
        User user=userRepo.findByUsername(name)
                .orElseThrow(()->new UsernameNotFoundException("Username not found"));
        List<ToDo> toDos=user.getTodos();
        List<TodoResDTO> toDoRes=new ArrayList<>();
        for(ToDo toDo:toDos){
            toDoRes.add(
                    TodoResDTO.builder()
                            .task(toDo.getTask())
                            .id(toDo.getId())
                            .isCompleted(toDo.isCompleted())
                            .build()
            );
        }
        return toDoRes;
    }
}
