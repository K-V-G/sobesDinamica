package com.example.bookService.service.rest;

import com.example.bookService.models.BookUserBookDTO;
import com.example.bookService.repository.BookUserBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InfoUserAndBookService implements InfoUserAndBookServiceInterface{
    private final BookUserBookRepo bookUserBookRepo;
    @Autowired
    public InfoUserAndBookService(BookUserBookRepo bookUserBookRepo) {
        this.bookUserBookRepo = bookUserBookRepo;
    }


    @Override
    public List<BookUserBookDTO> findAll() {
        return bookUserBookRepo.findAll().stream().map(BookUserBookDTO::new).collect(Collectors.toList());
    }
}
