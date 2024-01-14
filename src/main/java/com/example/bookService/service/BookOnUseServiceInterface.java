package com.example.bookService.service;

import com.example.bookService.models.BookUserBook;

public interface BookOnUseServiceInterface {
    BookUserBook addBookInUser(Integer userId, Integer bookId);
}
