package com.example.manageyourexpenditures.data;

import com.example.manageyourexpenditures.data.UserDto.UserDto;

public class UserDtoMapper {

    public static UserDto map(User user){
        String email = user.getEmail();
        String password = user.getPassword();
        String role = user.getRole().getName();
        return new UserDto(email,password,role);
    }


}
