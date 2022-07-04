package com.andrewn.java2305bookshelf.repository;

import com.andrewn.java2305bookshelf.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
