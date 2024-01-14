package com.example.bookService.repository;

import com.example.bookService.models.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookRepo extends JpaRepository<UserBook, Integer> {
}
