package com.example.manageyourexpenditures.data.model;

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
    @Column( name = "sum",scale = 2)
    private BigDecimal sum;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Long application_user_id;

    private LocalDate date;





}


