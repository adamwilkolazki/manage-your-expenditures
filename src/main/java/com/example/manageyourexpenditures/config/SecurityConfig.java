package com.example.manageyourexpenditures.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

@Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            requests -> requests

                    .requestMatchers("login","/register","/confirmation").permitAll()

                    .requestMatchers("/main.css").permitAll()

                    .anyRequest().authenticated());

    http.formLogin(login -> login.loginPage("/login").permitAll());
    http.csrf().disable();

    return http.build();


}
@Bean
    public PasswordEncoder passwordEncoder(){
      return PasswordEncoderFactories.createDelegatingPasswordEncoder();


}


}
