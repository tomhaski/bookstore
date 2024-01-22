package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private long id;

    @Column(nullable = false)
    private String name;

    private String surname;

    @Lob
    private String description;

}
