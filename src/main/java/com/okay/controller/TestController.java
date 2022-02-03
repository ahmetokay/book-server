package com.okay.controller;

import com.okay.model.BookDto;
import com.okay.service.BookService;
import com.okay.service.ParseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private final ParseService service;

    public TestController(ParseService service) {
        this.service = service;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<BookDto>> list() {
        return new ResponseEntity<>(service.parsePage(), HttpStatus.OK);
    }
}