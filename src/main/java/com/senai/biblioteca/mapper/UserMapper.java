package com.senai.biblioteca.mapper;

import com.senai.biblioteca.dto.requisicao.UserResquisition;
import com.senai.biblioteca.dto.respostas.BookResponse;
import com.senai.biblioteca.dto.respostas.UserResponse;
import com.senai.biblioteca.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public User toEntidy(UserResquisition requisition){
        return new User(requisition.nome(), requisition.email());
    }
    public UserResponse toResponse(User user){
        return new UserResponse(user.getId(), user.getNome(), user.getEmail());
    }

    public List<UserResponse> toListResponse(List<User> response){
        List<UserResponse> responses = new ArrayList<>();

        for (User user : response){
            responses.add(toResponse(user));
        }
        return responses;
    }
}
