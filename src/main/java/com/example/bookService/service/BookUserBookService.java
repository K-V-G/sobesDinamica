package com.example.bookService.service;

import com.example.bookService.models.BookUserBook;
import com.example.bookService.repository.BookUserBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookUserBookService implements BookUserBookServiceInterface {
    private final BookUserBookRepo bookUserBookRepo;
    @Autowired
    public BookUserBookService(BookUserBookRepo bookUserBookRepo) {
        this.bookUserBookRepo = bookUserBookRepo;
    }

    public BookUserBook save(BookUserBook bookUserBook) {
        return bookUserBookRepo.save(bookUserBook);
    }

    public List<BookUserBook> findAll() {
        return bookUserBookRepo.findAll();
    }
}
