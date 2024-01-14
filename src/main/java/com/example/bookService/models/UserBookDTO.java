package com.example.bookService.models;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UserBookDTO {
    public Integer id;

    public String FIO;

    public LocalDate birthday;

    public UserBookDTO(UserBook userBook) {
        this.id = userBook.getId();
        this.FIO = userBook.getFIO();
        this.birthday = userBook.getBirthday();
    }
}
