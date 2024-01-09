package com.example.manageyourexpenditures.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
 public class Expenditure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String description;
    private BigDecimal sum;
    @Enumerated(EnumType.STRING)
    private Category category;

    private LocalDate date;





}


