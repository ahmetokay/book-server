package com.okay.entity;

import com.okay.core.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "author")
public class AuthorEntity extends BaseEntity {

    @Column(name = "name")
    private String name;
}