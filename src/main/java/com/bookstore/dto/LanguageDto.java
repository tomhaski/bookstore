package com.bookstore.dto;

import com.bookstore.dto.enums.LanguageEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LanguageDto {

    private long id;
    @NotNull(message = "Language is mandatory")
    @Enumerated
    private LanguageEnum language;
}
