package com.okay.model;

import com.okay.core.BaseModel;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class BookDto extends BaseModel {

    private String name;

    private String description;

    private Date publishDate;

    private String isbn;

    private String language;

    private String imageUrl;

    private List<AuthorDto> authorList;

    private PublisherDto publisher;
}