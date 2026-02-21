package com.senai.biblioteca.service;

import com.senai.biblioteca.DAO.UserDAO;
import com.senai.biblioteca.dto.requisicao.UserResquisition;
import com.senai.biblioteca.dto.respostas.UserResponse;
import com.senai.biblioteca.mapper.UserMapper;
import com.senai.biblioteca.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService{

    UserDAO dao;
    UserMapper mapper;

    public UserService(UserDAO dao, UserMapper mapper){
        this.dao = dao;
        this.mapper = mapper;
    }
    public UserResponse signUser (UserResquisition requisition){
        try{
            User user = mapper.toEntidy(requisition);
            return mapper.toResponse(dao.signUser(user));
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<UserResponse> listUser(){
        try{
            return mapper.toListResponse(dao.listUser());
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public UserResponse listUserId(@PathVariable Long id){
        try{
            return mapper.toResponse(dao.listUserId(id));
        }catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public UserResponse UpdUser(UserResquisition requisition, @PathVariable Long id){
        try{
            User user = mapper.toEntidy(requisition);
            return mapper.toResponse(dao.UpdUser(user, id));
        } catch (SQLException | RuntimeException e ){
            throw new RuntimeException(e.getMessage());
        }
    }
    public void dltUser(Long id){
        try{
            dao.dltUser(id);
        }catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
