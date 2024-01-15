package com.example.manageyourexpenditures.web;

import com.example.manageyourexpenditures.data.model.Category;
import com.example.manageyourexpenditures.data.model.Expenditure;
import com.example.manageyourexpenditures.service.ExpenditureService;
import com.example.manageyourexpenditures.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    private final UserService userService;
    private final ExpenditureService expenditureService;


    @GetMapping("/")
    public String homeMethod(Model model) {
        String username = userService.showLoggedUsername();
        List<Expenditure> expendituresList = expenditureService.showAllExpenditures();

        model.addAttribute("username", username);
        model.addAttribute("expenditure", new Expenditure());
        model.addAttribute("list", expendituresList);


        return "index";
    }





    @PostMapping("/addexpenditure")
    public String addExpenditure(Expenditure expenditure, Model model) {
        expenditureService.addNewExpenditure(expenditure);
        return homeMethod(model);


    }
    @GetMapping("/delete/{id}")
    public String deleteExpenditure(Long id,Model model){
        expenditureService.deleteExpenditure(id);
        return homeMethod(model);
    }










}
