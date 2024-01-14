package com.example.bookService.service;

import com.example.bookService.models.Book;
import com.example.bookService.models.BookDTO;
import com.example.bookService.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService implements BookServiceInterface{

    private BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<BookDTO> findAll() {
        return bookRepo.findAll().stream().map(BookDTO::new).collect(Collectors.toList());
    }

    public Optional<Book> findById(Integer id) {
        return bookRepo.findById(id);
    }

    public Book save(Book book) {
        return bookRepo.save(book);
    }
}
