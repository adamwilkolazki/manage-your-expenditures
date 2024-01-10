package com.example.manageyourexpenditures.repository;

import com.example.manageyourexpenditures.data.Expenditure;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenditureRepository extends ListCrudRepository<Expenditure,Long> {


    List<Expenditure> findAllByCategory(String Category);
}
