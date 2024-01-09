package com.example.manageyourexpenditures.repository;

import com.example.manageyourexpenditures.data.Expenditure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenditureRepository extends CrudRepository<Expenditure,Long> {


    List<Expenditure> findAllByCategory(String Category);
}
