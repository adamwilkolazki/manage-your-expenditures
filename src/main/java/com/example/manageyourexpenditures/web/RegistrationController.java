package com.example.manageyourexpenditures.web;

import com.example.manageyourexpenditures.user.UserService;
import com.example.manageyourexpenditures.user.dto.UserRegistrationDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RegistrationController {
    UserService userService;

    @GetMapping("/register")
public String registrationForm(Model model){
        UserRegistrationDto user = new UserRegistrationDto();
        model.addAttribute("user",user);
        return "registration-form";

    }
    @PostMapping("/register")
    String register(UserRegistrationDto userRegistrationDto){
        userService.register(userRegistrationDto);
        return "redirect:/confirmation";
    }
@GetMapping("/confirmation")
    String registrationConfirmation(){
        return "registration-confirmation";

    }

}
