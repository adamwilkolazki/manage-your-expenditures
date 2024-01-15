package com.example.manageyourexpenditures.data.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "application_user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private BigDecimal accountBalance;

   @OneToMany(fetch = FetchType.EAGER)
   @JoinColumn(name = "application_user_id",referencedColumnName = "id")
   private List<Expenditure> expenditures;
    @ManyToOne()
    private UserRole role;
}
