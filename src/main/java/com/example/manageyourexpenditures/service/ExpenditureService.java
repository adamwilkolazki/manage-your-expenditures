package com.example.manageyourexpenditures.service;

import com.example.manageyourexpenditures.data.Expenditure;
import com.example.manageyourexpenditures.data.User;
import com.example.manageyourexpenditures.repository.ExpenditureRepository;
import com.example.manageyourexpenditures.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpenditureService {

    private final ExpenditureRepository expenditureRepository;
    private final UserRepository userRepository;


@Transactional
    public void addNewExpenditure(Expenditure expenditure){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByEmail(name).get();
        expenditure.setApplication_user_id(user.getId());
        expenditureRepository.save(expenditure);
    }

    public List<Expenditure> showAllExpenditures(){
     return expenditureRepository.findAll();
    }









}
