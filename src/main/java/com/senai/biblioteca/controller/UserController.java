package com.senai.biblioteca.controller;

import com.senai.biblioteca.dto.requisicao.UserResquisition;
import com.senai.biblioteca.dto.respostas.UserResponse;
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
    public UserResponse signUser(@RequestBody UserResquisition user) {
        return service.signUser(user);
    }
    @GetMapping
    public List<UserResponse> listUser(){
        return service.listUser();
    }
    @GetMapping("/{id}")
    public UserResponse listUserId(Long id){
        return service.listUserId(id);
    }
    @PutMapping("/{id}")
    public UserResponse updUser(@RequestBody UserResquisition user, @PathVariable Long id){
        return service.UpdUser(user, id);
    }
    @DeleteMapping("/{id}")
    public void dltUser(@PathVariable Long id){
        service.dltUser(id);
    }

}
