package com.senai.biblioteca.DAO;

import com.senai.biblioteca.model.User;
import com.senai.biblioteca.utils.DataBase;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    public User signUser(User user) throws SQLException{
        String query = "insert into usuario (nome, email) values (?,?)";
        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                user.setId(rs.getLong(1));
            }
        }
        return user;
    }
    public List<User> listUser() throws SQLException{
        ArrayList<User> list = new ArrayList<>();

        String query = "select id, nome, email from usuario";
        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                list.add(new User(rs.getLong("id"), rs.getString("nome"),rs.getString("email")));
            }
            return list;
        }

    }
    public User listUserId(Long id) throws SQLException{
        String query ="select id, nome, email from usuario where id = ?";

        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return new User(rs.getLong("id"),rs.getString("nome"),rs.getString("email"));
            }
        }
        return null;
    }
    public User UpdUser (User user, Long id) throws SQLException{
        String query = "update usuario set nome = ?, email = ? where id = ?";

        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query)){

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setLong(3, id);
            stmt.executeUpdate();
        }
        user.setId(id);
        return user;
    }
    public void dltUser (Long id) throws SQLException{
        String query = "delete from usuario where id = ?";

        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query)){

            stmt.setLong(1 ,id);
            stmt.executeUpdate();

        }
    }
    public boolean userExists(Long id) throws SQLException{
        String query = "select id, nome, email from usuario where id = ?";
        try(Connection conn = DataBase.connect();
            var stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return true;
            }
        }
        return false;
    }

}
