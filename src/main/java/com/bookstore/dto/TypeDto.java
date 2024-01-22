package com.bookstore.dto;

import com.bookstore.dto.enums.TypeEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TypeDto {

    private long id;
    @NotNull(message = "Type is mandatory")
    @Enumerated
    private TypeEnum type;
}
