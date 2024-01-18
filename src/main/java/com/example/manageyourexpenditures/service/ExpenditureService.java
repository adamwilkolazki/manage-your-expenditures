package com.example.manageyourexpenditures.service;

import com.example.manageyourexpenditures.data.dto.ExpenditureDto.ExpenditureDto;
import com.example.manageyourexpenditures.data.dto.ExpenditureDto.ExpenditureDtoMapper;
import com.example.manageyourexpenditures.data.model.Category;
import com.example.manageyourexpenditures.data.model.Expenditure;
import com.example.manageyourexpenditures.data.model.User;
import com.example.manageyourexpenditures.repository.ExpenditureRepository;
import com.example.manageyourexpenditures.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
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

    @Transactional
    public void deleteExpenditure(Long id){
    expenditureRepository.findById(id).ifPresent(expenditureRepository::delete);
    }

    @Transactional
    public void edit(Long id,String description,BigDecimal sum,Category category, LocalDate date){
        Expenditure expenditure = expenditureRepository.findById(id).get();
        expenditure.setDescription(description);
        expenditure.setSum(sum);
        expenditure.setCategory(category);
        expenditure.setDate(date);

    }


    public List<Expenditure> showAllExpenditures(){
     return expenditureRepository.findAll();
    }

    public List<ExpenditureDto> showThisMonthExpenditure(){
        Month actualMonth = LocalDate.now().getMonth();
      return   showAllExpenditures().stream()
              .map(ExpenditureDtoMapper::map)
                .filter(expenditure -> (expenditure.getDate().getMonth()).equals(actualMonth))
                .toList();
    }




public BigDecimal sumExpensesByCategory(Category category){
 return showThisMonthExpenditure().stream()
          .filter(e->e.getCategory().equals(category.name()))
          .map(ExpenditureDto::getSum)
          .reduce(BigDecimal.ZERO,BigDecimal::add);
}

public BigDecimal sumMonthlyExpenditures(){
    return showThisMonthExpenditure().stream()
            .map(ExpenditureDto::getSum)
            .reduce(BigDecimal.ZERO,BigDecimal::add);

}
















}
