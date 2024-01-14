package com.example.bookService.restController;

import com.example.bookService.models.BookUserBookDTO;
import com.example.bookService.service.rest.InfoUserAndBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/info")
public class InfoUserAndBookRestController {
    private final InfoUserAndBookService infoUserAndBookService;
    @Autowired
    public InfoUserAndBookRestController(InfoUserAndBookService infoUserAndBookService) {
        this.infoUserAndBookService = infoUserAndBookService;
    }

    @GetMapping("")
    public ResponseEntity<List<BookUserBookDTO>> getInfo() {
        List<BookUserBookDTO> bookUserBookDTOS = infoUserAndBookService.findAll();
        return new ResponseEntity<>(bookUserBookDTOS, HttpStatus.OK);
    }
}
