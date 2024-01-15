package com.example.manageyourexpenditures.data.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDto {


    private String email;
    private String password;
    private String role;
}
