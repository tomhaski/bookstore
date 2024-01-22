package com.bookstore.entity;

import com.bookstore.dto.enums.CoverEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Data
public class Cover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private long id;

    @Column(nullable = false, columnDefinition = "CHAR(4)")
    @Enumerated(EnumType.STRING)
    private CoverEnum type;

}
