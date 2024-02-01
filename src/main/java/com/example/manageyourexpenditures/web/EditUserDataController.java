package com.example.manageyourexpenditures.web;

import com.example.manageyourexpenditures.data.model.User;
import com.example.manageyourexpenditures.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class EditUserDataController {
    private final UserService userService;


    @GetMapping("/editpass")
    public String editPasswordPage(){
      return "edit-user";
    }

  @PostMapping("/change-password")
    String changePassword(@RequestParam String newPassword){
      userService.editUserPassword(newPassword);
      return "redirect:/logout ";
  }






}
