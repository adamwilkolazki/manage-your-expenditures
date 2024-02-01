package com.example.manageyourexpenditures.service;

import com.example.manageyourexpenditures.data.dto.UserDto.UserDto;
import com.example.manageyourexpenditures.data.dto.UserDto.UserDtoMapper;
import com.example.manageyourexpenditures.data.dto.UserDto.UserRegistrationDto;
import com.example.manageyourexpenditures.data.model.Expenditure;
import com.example.manageyourexpenditures.data.model.User;
import com.example.manageyourexpenditures.data.model.UserRole;
import com.example.manageyourexpenditures.repository.ExpenditureRepository;
import com.example.manageyourexpenditures.repository.UserRepository;
import com.example.manageyourexpenditures.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;


    private final static String USER_ROLE = "USER";


    public Optional<UserDto> findUserDtoByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .map(UserDtoMapper::map);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);

    }

    @Transactional
    public void register(UserRegistrationDto register) {

        User user = new User();
        user.setFirstName(register.getFirstName());
        user.setLastName(register.getLastName());
        user.setEmail(register.getEmail());
        String passwordHash = passwordEncoder.encode(register.getPassword());
        user.setPassword(passwordHash);
        user.setAccountBalance(BigDecimal.ZERO);
        Optional<UserRole> role = userRoleRepository.findByName(USER_ROLE);
        role.ifPresentOrElse(
                user::setRole,
                () -> {
                    throw new NoSuchElementException();
                }
        );
        userRepository.save(user);

    }

    public String showLoggedUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();

    }

    @Transactional
    public void editUserPassword(String newPassword) {
        String currentUsername = showLoggedUsername();
        User user = userRepository.findUserByEmail(currentUsername).orElseThrow();
        String hashedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(hashedPassword);
    }


}






