package com.example.manageyourexpenditures.user;

import com.example.manageyourexpenditures.user.dto.UserDto;
import com.example.manageyourexpenditures.user.dto.UserRegistrationDto;
import lombok.AllArgsConstructor;
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

}
