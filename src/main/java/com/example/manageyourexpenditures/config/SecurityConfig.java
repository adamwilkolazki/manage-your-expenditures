package com.example.manageyourexpenditures.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
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
                    .requestMatchers(PathRequest.toH2Console()).permitAll()

                    .requestMatchers("/main.css","register.css","list.css").permitAll()


                    .anyRequest().authenticated());

    http.formLogin(login -> login.loginPage("/login").permitAll());
    http.csrf().disable();
    http.headers().frameOptions().sameOrigin();

    return http.build();


}
@Bean
    public PasswordEncoder passwordEncoder(){
      return PasswordEncoderFactories.createDelegatingPasswordEncoder();


}


}
