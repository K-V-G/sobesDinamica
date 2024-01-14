package com.example.bookService.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookUserBookDTO {
    public String FIO;

    public LocalDate birthday;

    public String nameOfBook;

    public String author;

    public String ISBN;

    public LocalDate dateTaken;

    public BookUserBookDTO(BookUserBook bookUserBook) {
        this.FIO = bookUserBook.getUser().getFIO();
        this.birthday = bookUserBook.getUser().getBirthday();
        this.nameOfBook = bookUserBook.getBook().getName();
        this.author = bookUserBook.getBook().getAuthor();
        this.ISBN = bookUserBook.getBook().getISBN();
        this.dateTaken = bookUserBook.getDateTaken();
    }
}
