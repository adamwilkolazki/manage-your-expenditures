package com.example.manageyourexpenditures.service;

import com.example.manageyourexpenditures.data.*;
import com.example.manageyourexpenditures.data.UserDto.UserDto;
import com.example.manageyourexpenditures.data.UserDto.UserRegistrationDto;
import com.example.manageyourexpenditures.repository.UserRepository;
import com.example.manageyourexpenditures.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final static String USER_ROLE = "USER";


    public Optional<UserDto> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .map(UserDtoMapper::map);
    }
@Transactional
    public void register(UserRegistrationDto register) {

        User user = new User();
        user.setFirstName(register.getFirstName());
        user.setLastName(register.getLastName());
        user.setEmail(register.getEmail());
        String passwordHash = passwordEncoder.encode(register.getPassword());
        user.setPassword(passwordHash);
        Optional<UserRole> role = userRoleRepository.findByName(USER_ROLE);
        role.ifPresentOrElse(
                user::setRole,
                () -> {
                    throw new NoSuchElementException();
                }
        );
        userRepository.save(user);

    }

    public String showLoggedUsername(){
         String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
         return loggedUserName;
    }

}
