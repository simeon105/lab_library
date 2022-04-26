package com.example.lab_library.service;

import com.example.lab_library.model.Author;
import com.example.lab_library.model.Book;
import com.example.lab_library.model.dto.BookDto;
import com.example.lab_library.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(String name, Category category, long author, int availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, String name, Category category, Long author, int availableCopies);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> markAsTaken(Long id);
}
