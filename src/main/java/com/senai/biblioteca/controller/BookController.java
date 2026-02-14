package com.senai.biblioteca.controller;

import com.senai.biblioteca.model.Book;
import com.senai.biblioteca.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    BookService service;
public BookController(BookService service){
    this.service = service;
}
    @PostMapping
    public Book cadastrarBook(@RequestBody Book book){
        return service.signBook(book);
    }
    @GetMapping
    public List<Book> listBook(){
        return service.listBook();
    }
    @GetMapping("/{id}")
    public Book listBookId(@PathVariable Long id){
        return service.listBookId(id);
    }
    @PutMapping("/{id}")
    public Book updBook(@RequestBody Book book,@PathVariable Long id){
        return service.uptadeBook(book, id);
    }
    @DeleteMapping("/{id}")
    public void dltBook(@PathVariable Long id){
        service.deleteBook(id);
    }
}
