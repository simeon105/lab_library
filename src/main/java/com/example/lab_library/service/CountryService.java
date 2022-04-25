package com.example.lab_library.service;

import com.example.lab_library.model.Book;
import com.example.lab_library.model.Country;
import com.example.lab_library.model.dto.BookDto;
import com.example.lab_library.model.dto.CountryDto;
import com.example.lab_library.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(String name, String continent);

    Optional<Country> save(CountryDto countryDto);

    Optional<Country> edit(Long id, String name, String continent);

    Optional<Country> edit(Long id, CountryDto countryDto);

    void deleteById(Long id);
}
