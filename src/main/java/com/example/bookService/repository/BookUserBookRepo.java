package com.example.bookService.repository;

import com.example.bookService.models.BookUserBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookUserBookRepo extends JpaRepository<BookUserBook, Integer> {
}
