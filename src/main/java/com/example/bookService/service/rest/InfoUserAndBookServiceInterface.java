package com.example.bookService.service.rest;

import com.example.bookService.models.BookUserBookDTO;

import java.util.List;

public interface InfoUserAndBookServiceInterface {
    List<BookUserBookDTO> findAll();
}
