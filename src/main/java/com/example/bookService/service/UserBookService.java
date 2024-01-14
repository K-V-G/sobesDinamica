package com.example.bookService.service;

import com.example.bookService.models.UserBook;
import com.example.bookService.models.UserBookDTO;
import com.example.bookService.repository.UserBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserBookService implements UserBookServiceInterface {

    private UserBookRepo userBookRepo;

    @Autowired
    public UserBookService(UserBookRepo userBookRepo) {
        this.userBookRepo = userBookRepo;
    }

    public List<UserBookDTO> findAll() {
        return userBookRepo.findAll().stream().map(UserBookDTO::new).collect(Collectors.toList());
    }

    public Optional<UserBook> findById(Integer id) {
        return userBookRepo.findById(id);
    }

    public UserBook save(UserBook userBook) {
        return userBookRepo.save(userBook);
    }
}
