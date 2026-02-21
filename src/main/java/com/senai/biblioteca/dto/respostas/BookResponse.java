package com.senai.biblioteca.dto.respostas;

import com.senai.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public record BookResponse(Long id, String title, String author, int publicationYear) {
}



