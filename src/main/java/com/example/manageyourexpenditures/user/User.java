package com.example.manageyourexpenditures.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "application_user")
@Getter
@Setter
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private BigDecimal accountBalance = BigDecimal.ZERO;
    @OneToMany
    @JoinColumn (name = "appUserId")
    private List<Expenditure> expenditures;
    @ManyToOne()
    private UserRole role;
}
