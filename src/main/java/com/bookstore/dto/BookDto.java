package com.bookstore.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class BookDto {

    private long id;
    @NotBlank(message = "Name is mandatory")
    private String title;
    @NotNull(message = "Year is mandatory")
    @Positive(message = "Year must be greater then zero")
    private int year;
    @NotNull(message = "Pages is mandatory")
    @Positive(message = "Pages must be greater then zero")
    private int pages;
    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be greater then zero")
    private double price;
    @NotNull(message = "Amount is mandatory")
    @PositiveOrZero(message = "Amount must be greater then or equal zero")
    private int amount;
    private String description;

    private Set<@Valid AuthorDto> authors = new HashSet<>();
    private Set<@Valid CoverDto> covers = new HashSet<>();
    private Set<@Valid LanguageDto> languages = new HashSet<>();
    private Set<@Valid TypeDto> types = new HashSet<>();
    private Set<@Valid GenreDto> genres = new HashSet<>();
}
