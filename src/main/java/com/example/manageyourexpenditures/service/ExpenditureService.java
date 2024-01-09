package com.example.manageyourexpenditures.service;

import com.example.manageyourexpenditures.data.Expenditure;
import com.example.manageyourexpenditures.repository.ExpenditureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpenditureService {

    private final ExpenditureRepository expenditureRepository;



    public void addNewExpenditure(Expenditure expenditure){
        expenditureRepository.save(expenditure);
    }

    public List<Expenditure> showByCategory(String category){
        return expenditureRepository.findAllByCategory(category);
    }





}
