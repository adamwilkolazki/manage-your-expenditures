package com.example.manageyourexpenditures.web;

import com.example.manageyourexpenditures.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {
    private final UserService userService;


@GetMapping("/")
    public String homeMethod(Model model){
    String username = userService.showLoggedUsername();
    model.addAttribute("username", username);

    return "index";
}




}
