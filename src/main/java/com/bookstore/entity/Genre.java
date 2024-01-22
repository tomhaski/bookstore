package com.bookstore.entity;

import com.bookstore.dto.enums.GenreEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private long id;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private GenreEnum genre;
}
