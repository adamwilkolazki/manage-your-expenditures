package com.example.manageyourexpenditures.web;

import com.example.manageyourexpenditures.data.model.Expenditure;
import com.example.manageyourexpenditures.service.ExpenditureService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Month;
import java.util.List;

@Controller
@AllArgsConstructor
public class ExpenditureListController {
    private final ExpenditureService expenditureService;


    @RequestMapping("/list")
    public String getFilteredList(Model model, @Param("keyword") String keyword){
        List<Expenditure> expenditures = expenditureService.filterExpenditures(keyword);
        model.addAttribute("expenditures",expenditures);
        model.addAttribute("keyword",keyword);

        return "full-expenditure-list";
    }





}
