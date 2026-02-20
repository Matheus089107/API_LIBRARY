package com.senai.biblioteca.service;

import com.senai.biblioteca.DAO.UserDAO;
import com.senai.biblioteca.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService{

    UserDAO dao;

    public UserService(UserDAO dao){
        this.dao = dao;
    }
    public User signUser (User user){
        try{
            return dao.signUser(user);
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<User> listUser(){
        try{
            return dao.listUser();
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public User listUserId(@PathVariable Long id){
        try{
            return dao.listUserId(id);
        }catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public User UpdUser(User user, @PathVariable Long id){
        try{
            return dao.UpdUser(user, id);
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
