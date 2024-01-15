package com.example.manageyourexpenditures.web;

import com.example.manageyourexpenditures.data.model.Expenditure;
import com.example.manageyourexpenditures.repository.ExpenditureRepository;
import com.example.manageyourexpenditures.service.ExpenditureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class EditExpenditureController {

    ExpenditureRepository expenditureRepository;
    ExpenditureService expenditureService;

    @GetMapping("/edit/{id}")
    public String editExpenditureform(Model model, Long id){
        Expenditure expenditure = expenditureRepository.findById(id).get();
        model.addAttribute("expenditure", expenditure);
        return "edit-expenditure";



}
@PostMapping("/edit")
    public String editExpenditure(Expenditure expenditure) {
        expenditureService.edit(expenditure.getId(),expenditure.getDescription(),expenditure.getSum(),expenditure.getCategory(),expenditure.getDate());

        return ("redirect:/");
}

}
