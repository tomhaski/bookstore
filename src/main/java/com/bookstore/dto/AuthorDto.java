package com.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AuthorDto {

    private long id;
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String surname;
    private String description;
}
