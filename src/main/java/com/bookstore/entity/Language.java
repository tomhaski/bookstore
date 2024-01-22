package com.bookstore.entity;

import com.bookstore.dto.enums.LanguageEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Data
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private long id;

    @Column(nullable = false, columnDefinition = "CHAR(2)")
    @Enumerated(EnumType.STRING)
    private LanguageEnum language;

}
