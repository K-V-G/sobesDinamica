package com.example.bookService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "user_book")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserBook {
    @Id
    @SequenceGenerator(name = "USER_BOOK_ID_SEQUENCE", sequenceName = "user_book_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_BOOK_ID_SEQUENCE")
    private Integer id;

    @Column(name = "fio")
    private String FIO;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @OneToMany(mappedBy = "user")
    private Set<BookUserBook> userBooks;

}
