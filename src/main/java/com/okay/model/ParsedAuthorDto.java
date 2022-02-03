package com.okay.model;

import java.io.Serializable;

public class ParsedAuthorDto implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }
}