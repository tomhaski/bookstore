package com.bookstore.repository;

import com.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitle(String title);

    int deleteBookById(Long id);

    boolean existsById(Long id);

    boolean existsByTitleAndYear(String title, int year);

}
