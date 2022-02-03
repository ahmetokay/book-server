package com.okay.entity;

import com.okay.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "book")
public class BookEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "language")
    private String language;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "fk_author_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "fk_book_id", referencedColumnName = "id", nullable = false))
    private List<AuthorEntity> authorList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_publisher_id")
    private PublisherEntity publisher;
}