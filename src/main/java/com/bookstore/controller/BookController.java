package com.bookstore.controller;

import com.bookstore.dto.BookDto;
import com.bookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;


    @PostMapping("/create")
    public ResponseEntity<String> createBook(@Valid @RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @GetMapping("/get")
    public ResponseEntity<List<BookDto>> getBooksByTitle(@RequestParam(value = "title") String title) {
        return bookService.getBooksByTitle(title);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBook(@RequestParam(value = "id") Long id) {
        return bookService.deleteBookById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<BookDto> updateBook(@Valid @RequestBody BookDto bookDto) {
        return bookService.updateBook(bookDto);
    }
}
