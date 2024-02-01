package com.example.manageyourexpenditures.repository;

import com.example.manageyourexpenditures.data.model.Category;
import com.example.manageyourexpenditures.data.model.Expenditure;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenditureRepository extends ListCrudRepository<Expenditure,Long> {


List<Expenditure> findAllByCategory(Category category);
@Query ("SELECT e from Expenditure  e WHERE CONCAT(e.description, ' ',e.category, '',e.date) LIKE %?1%")
List<Expenditure> search (String keyword);


}
