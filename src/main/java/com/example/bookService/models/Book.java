package com.example.bookService.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    @Id
    @SequenceGenerator(name = "BOOK_ID_GENERATOR", sequenceName = "book_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_ID_GENERATOR")
    private Integer id;

    private String name;
    @Column(name = "author")
    private String author;

    @Column(name = "isbn")
    private String ISBN;

    @OneToMany(mappedBy = "book")
    private Set<BookUserBook> books;
}
