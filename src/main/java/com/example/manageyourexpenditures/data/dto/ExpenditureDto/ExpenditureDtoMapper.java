package com.example.manageyourexpenditures.data.dto.ExpenditureDto;

import com.example.manageyourexpenditures.data.dto.ExpenditureDto.ExpenditureDto;
import com.example.manageyourexpenditures.data.model.Expenditure;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenditureDtoMapper {

    public static ExpenditureDto map(Expenditure expenditure){
        Long id = expenditure.getId();
        String description = expenditure.getDescription();
        BigDecimal sum = expenditure.getSum();
        String category = expenditure.getCategory().name();
        LocalDate date = expenditure.getDate();
        return new ExpenditureDto(id,description,sum,category,date);
    }
}
