package com.example.manageyourexpenditures.data.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    public UserDto(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    private String email;
    private String password;
    private String role;
    private BigDecimal accountBalance;
}
