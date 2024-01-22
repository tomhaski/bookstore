package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicInsert
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int pages;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int amount;

    @Lob
    private String description;

    @ManyToMany(targetEntity = Author.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "books_authors", joinColumns = {@JoinColumn(name = "book_id")}, inverseJoinColumns = {@JoinColumn(name = "author_id")})
    Set<Author> authors = new HashSet<>();

    @ManyToMany(targetEntity = Cover.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "books_covers", joinColumns = {@JoinColumn(name = "book_id")}, inverseJoinColumns = {@JoinColumn(name = "cover_id")})
    Set<Cover> covers = new HashSet<>();

    @ManyToMany(targetEntity = Language.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "books_languages", joinColumns = {@JoinColumn(name = "book_id")}, inverseJoinColumns = {@JoinColumn(name = "language_id")})
    Set<Language> languages = new HashSet<>();

    @ManyToMany(targetEntity = Type.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "books_types", joinColumns = {@JoinColumn(name = "book_id")}, inverseJoinColumns = {@JoinColumn(name = "type_id")})
    Set<Type> types = new HashSet<>();

    @ManyToMany(targetEntity = Genre.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "books_genres", joinColumns = {@JoinColumn(name = "book_id")}, inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    Set<Genre> genres = new HashSet<>();

}
