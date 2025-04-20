package com.shobhit.Backend.controller;

import com.shobhit.Backend.dto.TodoReqDTO;
import com.shobhit.Backend.dto.TodoResDTO;
import com.shobhit.Backend.service.ToDoService;
import com.shobhit.Backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;
    @PostMapping
    public TodoResDTO addToDo(Authentication authentication,@Valid @RequestBody TodoReqDTO todo){
        return toDoService.addToDo(authentication.getName(),todo);
    }
    @GetMapping
    public List<TodoResDTO> getAll(Authentication authentication){
        return toDoService.getALl(authentication.getName());
    }
    @DeleteMapping("/{id}")
    public void deleteById(Authentication authentication,@PathVariable long id) throws AccessDeniedException {
        toDoService.delete(authentication.getName(),id);
    }
    @PutMapping("/{id}")
    public void update(Authentication authentication,@PathVariable long id) throws AccessDeniedException {
        toDoService.update(authentication.getName(),id);
    }
}
