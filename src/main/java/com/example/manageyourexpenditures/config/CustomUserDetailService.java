package com.example.manageyourexpenditures.config;

import com.example.manageyourexpenditures.service.UserService;
import com.example.manageyourexpenditures.data.dto.UserDto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class CustomUserDetailService implements UserDetailsService {

    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = findUser(username);
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole()).build();

    }

    private UserDto findUser(String username){
        return  userService.findUserDtoByEmail(username).orElseThrow(()->new UsernameNotFoundException(String.format("Can't find user with email %s",username)));

    }
}
