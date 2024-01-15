package com.example.manageyourexpenditures.data.dto.UserDto;

import com.example.manageyourexpenditures.data.model.User;

public class UserDtoMapper {

    public static UserDto map(User user){
        String email = user.getEmail();
        String password = user.getPassword();
        String role = user.getRole().getName();
        return new UserDto(email,password,role);
    }


}
