package com.example.bookService.service;

import com.example.bookService.models.UserBook;
import com.example.bookService.models.UserBookDTO;

import java.util.List;
import java.util.Optional;

public interface UserBookServiceInterface {
    List<UserBookDTO> findAll();

    Optional<UserBook> findById(Integer id);

    UserBook save(UserBook userBook);
}
