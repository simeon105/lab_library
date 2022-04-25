package com.example.lab_library.service.impl;

import com.example.lab_library.model.Author;
import com.example.lab_library.model.Book;
import com.example.lab_library.model.Country;
import com.example.lab_library.model.dto.AuthorDto;
import com.example.lab_library.model.dto.BookDto;
import com.example.lab_library.model.enumerations.Category;
import com.example.lab_library.model.exceptions.AuthorNotFoundException;
import com.example.lab_library.model.exceptions.BookNotFoundException;
import com.example.lab_library.model.exceptions.CountryNotFoundException;
import com.example.lab_library.repository.AuthorRepository;
import com.example.lab_library.repository.BookRepository;
import com.example.lab_library.repository.CountryRepository;
import com.example.lab_library.service.AuthorService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundException(countryId));

        Author author = new Author(name, surname, country);
        this.authorRepository.save(author);

        return Optional.of(author);
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Author author = new Author(authorDto.getName(), authorDto.getSurname(), authorDto.getCountry());

        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> edit(Long id, String name, String surname, Long countryId) {
        Author author = this.authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));

        author.setName(name);
        author.setSurname(surname);

        Country country = this.countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundException(countryId));
        author.setCountry(country);

        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> edit(Long id, AuthorDto authorDto) {
        Author author = this.authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));

        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setCountry(authorDto.getCountry());

        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
