package com.senai.biblioteca.service;

import com.senai.biblioteca.DAO.BookDAO;
import com.senai.biblioteca.dto.requisicao.BookRequisition;
import com.senai.biblioteca.dto.respostas.BookResponse;
import com.senai.biblioteca.mapper.BookMapper;
import com.senai.biblioteca.model.Book;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {
    BookDAO dao;
    BookMapper mapper;

    public BookService(BookDAO dao, BookMapper mapper){
        this.dao = dao;
        this.mapper = mapper;
    }

    public BookResponse signBook (BookRequisition requisition){
        try{
            Book book = mapper.toEntidy(requisition);
            return mapper.toResponse(dao.SignBook(book));
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<BookResponse> listBook(){
        try{
           return mapper.toListResponse(dao.getAllBooks());
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }
    public BookResponse listBookId(Long id){
        try{
            return mapper.toResponse(dao.getBookId(id));
        }catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public BookResponse uptadeBook(BookRequisition requisition, Long id){
        try{
            Book book = mapper.toEntidy(requisition);
           return mapper.toResponse(dao.getBookId(id));
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
