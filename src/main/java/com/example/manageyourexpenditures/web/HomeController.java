package com.example.manageyourexpenditures.web;


import com.example.manageyourexpenditures.data.dto.ExpenditureDto.ExpenditureDto;
import com.example.manageyourexpenditures.data.model.Category;
import com.example.manageyourexpenditures.data.model.Expenditure;
import com.example.manageyourexpenditures.data.model.User;
import com.example.manageyourexpenditures.service.ExpenditureService;
import com.example.manageyourexpenditures.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class HomeController {
    private final UserService userService;
    private final ExpenditureService expenditureService;


    @GetMapping("/")
    public String homeMethod(Model model) {
        String username = userService.showLoggedUsername();
        List<ExpenditureDto> expenditureList = expenditureService.showThisMonthExpenditure();
        User user = userService.findUserByEmail(username).get();


        model.addAttribute("username", username);
        model.addAttribute("expenditure", new Expenditure());
        model.addAttribute("list", expenditureList);
        model.addAttribute("user",user);
        model.addAttribute("monthlyExpenditure",expenditureService.sumMonthlyExpenditures());
        model.addAttribute("bills", expenditureService.sumExpensesByCategory(Category.BILLS));
        model.addAttribute("shopping", expenditureService.sumExpensesByCategory(Category.SHOPPING));
        model.addAttribute("entertainment", expenditureService.sumExpensesByCategory(Category.ENTERTAINMENT));
        model.addAttribute("other", expenditureService.sumExpensesByCategory(Category.OTHER));






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














