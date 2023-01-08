package com.project.javalibrary.domain.book;

import lombok.Data;

@Data
public class Book {

    private Long id;
    private String title;
    private Integer quantity;

    public Book(String title, Integer quantity) {
        this.title = title;
        this.quantity = quantity;
    }
}
