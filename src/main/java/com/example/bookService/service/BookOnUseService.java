package com.example.bookService.service;

import com.example.bookService.models.Book;
import com.example.bookService.models.BookUserBook;
import com.example.bookService.models.UserBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookOnUseService implements BookOnUseServiceInterface{

    private final UserBookServiceInterface userBookService;

    private final BookServiceInterface bookService;

    private final BookUserBookServiceInterface bookUserBookServiceInterface;

    @Autowired
    public BookOnUseService(
            UserBookServiceInterface userBookService,
            BookServiceInterface bookService,
            BookUserBookServiceInterface bookUserBookServiceInterface) {
        this.userBookService = userBookService;
        this.bookService = bookService;
        this.bookUserBookServiceInterface = bookUserBookServiceInterface;
    }

    public BookUserBook addBookInUser(Integer userId, Integer bookId) {
        UserBook userBook = userBookService.findById(userId).get();
        Book book = bookService.findById(bookId).get();
        LocalDate localDate = LocalDate.now();
        BookUserBook bookUserBook = new BookUserBook(null, userBook, book, localDate);

        return bookUserBookServiceInterface.save(bookUserBook);
    }
}
