package com.okay.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParsedBookDto implements Serializable {

    private String name;

    private String description;

    private String image;

    private String isbn;

    private String numberOfPages;

    private ParsedAuthorDto author;

    private ParsedPublisherDto publisher;
}