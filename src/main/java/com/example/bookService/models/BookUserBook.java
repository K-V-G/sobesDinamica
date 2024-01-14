package com.example.bookService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book_user_books")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookUserBook {
    @Id
    @SequenceGenerator(name = "BOOK_USER_BOOK_ID_GENERATOR", sequenceName = "book_user_books_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_USER_BOOK_ID_GENERATOR")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserBook user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "date_taken")
    private LocalDate dateTaken;
}
