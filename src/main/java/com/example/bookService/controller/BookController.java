package com.example.bookService.controller;

import com.example.bookService.models.Book;
import com.example.bookService.models.BookDTO;
import com.example.bookService.service.BookService;
import com.example.bookService.service.BookServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/book")
public class BookController {
    private final BookServiceInterface bookService;

    @Autowired
    public BookController(BookServiceInterface bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/allBook")
    public String allBook(Model model) {
        List<BookDTO> bookOnDb = bookService.findAll();

        model.addAttribute("books", bookOnDb);
        return "allBook";
    }

    @GetMapping("/newBook")
    public String newBook(Model model) {
        model.addAttribute("newBook", new Book());
        return "newBook";
    }

    @PostMapping("/newBook")
    public String newBookPost(@ModelAttribute("newBook") Book newBook) {
        log.info("inert into new book " + newBook.toString());
        Book book = bookService.save(newBook);
        log.info("inserted book " + book.toString());
        return "redirect:/book/allBook";
    }

    @GetMapping("/change/{id}")
    public String changeBook(Model model, @PathVariable Integer id) {
        Book book = bookService.findById(id).get();
        model.addAttribute("changedBook", book);
        return "changedBook";
    }

    @PostMapping("/change/{id}")
    public String changeBookPost(@ModelAttribute("changedBook") Book chengedBook) {
        log.info("change info on book " + chengedBook.toString());
        Book book = bookService.save(chengedBook);
        log.info("new info " + book.toString());
        return "redirect:/book/allBook";
    }

}
