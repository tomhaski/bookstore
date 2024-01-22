package com.bookstore.service;

import com.bookstore.dto.BookDto;
import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.tools.ResponseValues;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public ResponseEntity<String> createBook(BookDto bookDto) {
        if (bookRepository.existsByTitleAndYear(bookDto.getTitle(), bookDto.getYear())) {
            return new ResponseEntity<>(ResponseValues.BOOK_EXIST.getMessage(), HttpStatus.BAD_REQUEST);
        }
        Book book = modelMapper.map(bookDto, Book.class);
        bookRepository.save(Objects.requireNonNull(book, "Book object must not be null."));
        return new ResponseEntity<>(ResponseValues.BOOK_CREATED.getMessage(), HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<List<BookDto>> getBooksByTitle(String title) {
        List<Book> books = bookRepository.findAllByTitle(title);
        if(books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<BookDto> bookDtos = books.parallelStream().map(book -> modelMapper.map(book, BookDto.class)).toList();
        return new ResponseEntity<>(bookDtos, HttpStatus.FOUND);
    }

    @Transactional
    public ResponseEntity<String> deleteBookById(Long id) {
        if (bookRepository.existsById(id)) {
            int result = bookRepository.deleteBookById(id);
            if (result==0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ResponseValues.BOOK_DELETED.getMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional
    public ResponseEntity<BookDto> updateBook(BookDto bookDto) {
        if(bookRepository.existsById(bookDto.getId())) {
            Book book = modelMapper.map(bookDto, Book.class);
            bookRepository.save(book);
            BookDto updatedBookDto = modelMapper.map(book, BookDto.class);
            return new ResponseEntity<>(updatedBookDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
