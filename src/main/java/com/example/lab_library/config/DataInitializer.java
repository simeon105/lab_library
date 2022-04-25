package com.example.lab_library.config;

import com.example.lab_library.model.Author;
import com.example.lab_library.model.Country;
import com.example.lab_library.model.enumerations.Category;
import com.example.lab_library.service.AuthorService;
import com.example.lab_library.service.BookService;
import com.example.lab_library.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataInitializer {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void initData() {
        this.countryService.save("Macedonia", "Europe");
        this.countryService.save("Serbia", "Europe");
        this.countryService.save("China", "Asia");
        this.countryService.save("Egypt", "Africa");
        this.countryService.save("United States", "North America");
        List<Country> countries = this.countryService.findAll();

        this.authorService.save("Simeon", "Markoski", (long) countries.get(0).getId());
        this.authorService.save("Eva", "Agovska", (long) countries.get(0).getId());
        this.authorService.save("Nikola", "Sekulovski", (long) countries.get(1).getId());
        this.authorService.save("Bojan", "Majstorov", (long) countries.get(2).getId());
        this.authorService.save("Rade", "Markoski", (long) countries.get(3).getId());
        this.authorService.save("Nikola", "Tesla", (long) countries.get(4).getId());
        this.authorService.save("Riste", "Spasovski", (long) countries.get(2).getId());
        this.authorService.save("Klara", "Agovska", (long) countries.get(1).getId());
        List<Author> authors = this.authorService.findAll();

        this.bookService.save("Da Vinci Code", Category.THRILER, authors.get(0).getId(), 6);
        this.bookService.save("Harry Potter and the Deathly Hallows", Category.CLASSICS, authors.get(1).getId(), 3);
        this.bookService.save("Harry Potter and the Philosopher's Stone", Category.BIOGRAPHY, authors.get(2).getId(), 8);
        this.bookService.save("Harry Potter and the Order of the Phoenix", Category.BIOGRAPHY, authors.get(3).getId(), 2);
        this.bookService.save("Fifty Shades of Grey", Category.FANTASY, authors.get(4).getId(), 3);
        this.bookService.save("Harry Potter and the Goblet of Fire", Category.NOVEL, authors.get(5).getId(), 7);
        this.bookService.save("Harry Potter and the Chamber of Secrets", Category.BIOGRAPHY, authors.get(6).getId(), 4);
        this.bookService.save("Harry Potter and the Prisoner of Azkaban", Category.BIOGRAPHY, authors.get(7).getId(), 3);
        this.bookService.save("Angels and Demons", Category.BIOGRAPHY, authors.get(2).getId(), 2);
        this.bookService.save("Fifty Shades Darker", Category.FANTASY, authors.get(4).getId(), 2);
    }
}
