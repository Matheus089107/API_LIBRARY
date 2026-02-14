package com.senai.biblioteca.service;

import com.senai.biblioteca.DAO.BookDAO;
import com.senai.biblioteca.model.Book;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {
    BookDAO dao;

    public BookService(BookDAO dao){
        this.dao = dao;
    }

    public Book signBook (Book book){
        try{
            return dao.SignBook(book);
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Book> listBook(){
        try{
           return dao.getAllBooks();
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }
    public Book listBookId(Long id){
        try{
            return dao.getBookId(id);
        }catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public Book uptadeBook(Book book, Long id){
        try{
           return dao.updBook(book, id);
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public void deleteBook(Long id){
        try{
            dao.dltBook(id);
        }catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
