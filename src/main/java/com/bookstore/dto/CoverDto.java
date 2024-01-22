package com.bookstore.dto;

import com.bookstore.dto.enums.CoverEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CoverDto {

    private long id;
    @NotNull(message = "Type is mandatory")
    @Enumerated
    private CoverEnum type;
}
