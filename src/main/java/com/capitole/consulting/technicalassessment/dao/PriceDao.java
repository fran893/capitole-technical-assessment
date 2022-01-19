package com.capitole.consulting.technicalassessment.dao;

import com.capitole.consulting.technicalassessment.model.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceDao extends CrudRepository<Price, Integer> {
}
