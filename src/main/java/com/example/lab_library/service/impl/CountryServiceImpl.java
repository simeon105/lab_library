package com.example.lab_library.service.impl;

import com.example.lab_library.model.Author;
import com.example.lab_library.model.Book;
import com.example.lab_library.model.Country;
import com.example.lab_library.model.dto.CountryDto;
import com.example.lab_library.model.exceptions.AuthorNotFoundException;
import com.example.lab_library.model.exceptions.BookNotFoundException;
import com.example.lab_library.model.exceptions.CountryNotFoundException;
import com.example.lab_library.repository.CountryRepository;
import com.example.lab_library.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country = new Country(name, continent);

        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {
        Country country = new Country(countryDto.getName(), countryDto.getContinent());

        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> edit(Long id, String name, String continent) {
        Country country = this.countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));

        country.setName(name);
        country.setContinent(continent);

        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> edit(Long id, CountryDto countryDto) {
        Country country = this.countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));

        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());

        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
