package com.senai.biblioteca.controller;

import com.senai.biblioteca.model.User;
import com.senai.biblioteca.service.BookService;
import com.senai.biblioteca.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService service;
    public UserController(UserService service){this.service = service;}
    @PostMapping
    public User signUser(@RequestBody User user) {
        return service.signUser(user);
    }
    @GetMapping
    public List<User> listUser(){
        return service.listUser();
    }
    @GetMapping("/{id}")
    public User listUserId(Long id){
        return service.listUserId(id);
    }
    @PutMapping
    public User updUser(){
        return null;
    }
    @DeleteMapping
    public User dltUser(){
        return null;
    }

}
