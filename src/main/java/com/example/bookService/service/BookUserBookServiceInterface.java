package com.example.bookService.service;

import com.example.bookService.models.BookUserBook;

import java.util.List;

public interface BookUserBookServiceInterface {
    BookUserBook save(BookUserBook bookUserBook);

    List<BookUserBook> findAll();
}
