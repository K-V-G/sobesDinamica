package com.example.bookService.models;

import lombok.Data;

@Data
public class BookDTO {
    private Integer id;

    public String name;

    public String author;

    public String ISBN;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.author = book.getAuthor();
        this.ISBN = book.getISBN();
    }
}
