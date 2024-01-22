package com.bookstore.dto;

import com.bookstore.dto.enums.GenreEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GenreDto {

    private long id;
    @NotNull(message = "Genre is mandatory")
    @Enumerated
    private GenreEnum genre;

}
