package com.example.bookService.controller;

import com.example.bookService.models.BookDTO;
import com.example.bookService.models.BookUserBook;
import com.example.bookService.models.UserBook;
import com.example.bookService.models.UserBookDTO;
import com.example.bookService.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/booksOnUser")
public class BooksOnUserController {

    private final UserBookServiceInterface userBookService;

    private final BookServiceInterface bookService;

    private final BookOnUseServiceInterface bookOnUseService;

    @Autowired
    public BooksOnUserController(
            UserBookServiceInterface userBookService,
            BookServiceInterface bookService,
            BookOnUseServiceInterface bookOnUseService) {
        this.userBookService = userBookService;
        this.bookService = bookService;
        this.bookOnUseService = bookOnUseService;
    }

    @GetMapping()
    public String booksOnUser(Model model) {
        List<UserBookDTO> userBooks = userBookService.findAll();
        List<BookDTO> books = bookService.findAll();

        model.addAttribute("users", userBooks);
        model.addAttribute("books", books);
        return "booksOnUser";
    }

    @PostMapping()
    public String booksOnUserPost(@RequestParam Integer userId, @RequestParam Integer bookId) throws BadRequestException {
        BookUserBook savedUser = bookOnUseService.addBookInUser(userId, bookId);
        if (savedUser == null) {
            throw new BadRequestException();
        }
        return "redirect:/";
    }
}
