package com.example.lab_library.model.dto;

import com.example.lab_library.model.Country;
import lombok.Data;

@Data
public class AuthorDto {

    private String name;

    private String surname;

    private Country country;

    public AuthorDto() {}

    public AuthorDto(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
