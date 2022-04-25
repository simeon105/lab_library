package com.example.lab_library.service;

import com.example.lab_library.model.Author;
import com.example.lab_library.model.Book;
import com.example.lab_library.model.Country;
import com.example.lab_library.model.dto.AuthorDto;
import com.example.lab_library.model.dto.BookDto;
import com.example.lab_library.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(String name, String surname, Long country);

    Optional<Author> save(AuthorDto authorDto);

    Optional<Author> edit(Long id, String name, String surname, Long country);

    Optional<Author> edit(Long id, AuthorDto authorDto);

    void deleteById(Long id);
}
