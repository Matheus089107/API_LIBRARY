package com.senai.biblioteca.mapper;

import com.senai.biblioteca.dto.requisicao.BookRequisition;
import com.senai.biblioteca.dto.respostas.BookResponse;
import com.senai.biblioteca.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapper {

    public Book toEntidy(BookRequisition requisition){
        return new Book(requisition.title(), requisition.author(), requisition.publicationYear());
    }
    public BookResponse toResponse(Book book){
        return new BookResponse(book.getId(), book.getTitle(), book.getAuthor(), book.getPublicationYear());
    }
    public List<BookResponse> toListResponse(List<Book> response){
        List<BookResponse> responses = new ArrayList<>();

        for(Book book : response){
            responses.add(toResponse(book));
        }
        return responses;
    }
}
