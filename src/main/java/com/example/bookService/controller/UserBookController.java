package com.example.bookService.controller;

import com.example.bookService.models.UserBook;
import com.example.bookService.models.UserBookDTO;
import com.example.bookService.service.UserBookServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserBookController {
    private final UserBookServiceInterface userBookService;

    @Autowired
    public UserBookController(UserBookServiceInterface userBookService) {
        this.userBookService = userBookService;
    }

    @GetMapping("/allUsers")
    public String allBook(Model model) {
        List<UserBookDTO> usersOnDB = userBookService.findAll();

        model.addAttribute("users", usersOnDB);
        return "allUsers";
    }

    @GetMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("newUser", new UserBook());
        return "newUserBook";
    }

    @PostMapping("/newUser")
    public String newUserPost(@ModelAttribute("newUser") UserBook newUser) {
        log.info("inert into new user " + newUser.toString());
        UserBook userBook = userBookService.save(newUser);
        log.info("inserted user " + userBook.toString());
        return "redirect:/user/allUsers";
    }

    @GetMapping("/change/{id}")
    public String changeUser(Model model, @PathVariable Integer id) {
        UserBook userBook = userBookService.findById(id).get();
        model.addAttribute("changedUser", userBook);
        return "changeUserBook";
    }

    @PostMapping("/change/{id}")
    public String changeUserPost(@ModelAttribute("changedUser") UserBook changedUser) {
        log.info("change info on user " + changedUser.toString());
        UserBook userBook = userBookService.save(changedUser);
        log.info("new info " + userBook.toString());
        return "redirect:/user/allUsers";
    }




}
