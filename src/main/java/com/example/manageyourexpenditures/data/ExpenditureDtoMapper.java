package com.example.manageyourexpenditures.data;

import com.example.manageyourexpenditures.data.ExpenditureDto.ExpenditureDto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenditureDtoMapper {

    public ExpenditureDto map(Expenditure expenditure){
        String description = expenditure.getDescription();
        BigDecimal sum = expenditure.getSum();
        String category = expenditure.getCategory().name();
        LocalDate date = expenditure.getDate();
        return new ExpenditureDto(description,sum,category,date);
    }
}
