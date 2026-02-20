package com.senai.biblioteca.DAO;

import com.senai.biblioteca.model.Book;
import com.senai.biblioteca.utils.DataBase;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDAO {

    public Book SignBook(Book book) throws SQLException {
        String query = "insert into livro (titulo, autor, ano_publicacao) values (?,?,?)";

        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3, book.getPublicationYear());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                book.setId(rs.getLong(1));
            }
            return book;
        }
    }
    public List<Book> getAllBooks() throws SQLException{
        String query = "SELECT id, titulo, autor, ano_publicacao from livro";
        List<Book> books = new ArrayList<>();
        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                books.add(new Book(rs.getLong("id"), rs.getString("titulo"),rs.getString("autor"),rs.getInt("ano_publicacao")));
            }
            return books;
        }
    }
    public Book getBookId(Long id) throws SQLException{
        String query = "select id, titulo,autor,ano_publicacao from livro where id = ?";

        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query)){

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return new Book(rs.getLong("id"), rs.getString("titulo"),rs.getString("autor"),rs.getInt("ano_publicacao"));
            }
        }
        return null;
    }
    public Book updBook(Book book, Long id) throws SQLException{
        String query="update livro set titulo = ?, autor = ?, ano_publicacao = ? where id = ?";

        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query)){

            stmt.setString(1,book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3, book.getPublicationYear());
            stmt.setLong(4, id);
            stmt.executeUpdate();
        }
        book.setId(id);
        return book;
    }
    public void dltBook(Long id) throws SQLException{
        String query = "delete from livro where id = ?";
        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query)){

            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
    public boolean bookExists(Long id) throws SQLException{
        String query = "select id, titulo,autor,ano_publicacao from livro where id = ?";
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
