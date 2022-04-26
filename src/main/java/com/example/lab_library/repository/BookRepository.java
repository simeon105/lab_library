package com.example.lab_library.repository;

import com.example.lab_library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {

    List<Book> findAllByNameLike(String text);

    void deleteByName(String name);

}
