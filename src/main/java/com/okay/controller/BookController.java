package com.okay.controller;

import com.okay.model.BookDto;
import com.okay.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<BookDto>> list() {
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }
}