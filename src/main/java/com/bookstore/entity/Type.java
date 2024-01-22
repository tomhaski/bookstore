package com.bookstore.entity;

import com.bookstore.dto.enums.TypeEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Data
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private long id;

    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    private TypeEnum type;

}
