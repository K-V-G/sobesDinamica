package com.example.bookService.service;

import com.example.bookService.models.Book;
import com.example.bookService.models.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookServiceInterface {
    List<BookDTO> findAll();

    Optional<Book> findById(Integer id);

    Book save(Book book);
}
