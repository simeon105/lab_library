package com.example.lab_library.model.dto;

import com.example.lab_library.model.Author;
import com.example.lab_library.model.enumerations.Category;
import lombok.Data;

@Data
public class BookDto {

    private String name;

    private Category category;

    private long author;

    private int availableCopies;

    public BookDto() {}

    public BookDto(String name, Category category, long author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
