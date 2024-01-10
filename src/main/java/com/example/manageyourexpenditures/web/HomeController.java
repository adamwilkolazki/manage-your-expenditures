package com.example.manageyourexpenditures.web;

import com.example.manageyourexpenditures.data.Category;
import com.example.manageyourexpenditures.data.Expenditure;
import com.example.manageyourexpenditures.service.ExpenditureService;
import com.example.manageyourexpenditures.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    private final UserService userService;
    private final ExpenditureService expenditureService;


@GetMapping("/")
    public String homeMethod(Model model){
    String username = userService.showLoggedUsername();
    List<Expenditure> expendituresList = expenditureService.showAllExpenditures();
    model.addAttribute("username", username);
    model.addAttribute("expenditure", new Expenditure());
    model.addAttribute("list",expendituresList);

    return "index";
}


@PostMapping("/addexpenditure")
public String addExpenditure(Expenditure expenditure){
    expenditureService.addNewExpenditure(expenditure);
    return "index";



}




}
