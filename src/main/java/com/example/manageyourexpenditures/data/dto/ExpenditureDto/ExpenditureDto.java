package com.example.manageyourexpenditures.data.dto.ExpenditureDto;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class ExpenditureDto {
    private Long id;

    private String description;
    private BigDecimal sum;

    private String category;

    private LocalDate date;
}
