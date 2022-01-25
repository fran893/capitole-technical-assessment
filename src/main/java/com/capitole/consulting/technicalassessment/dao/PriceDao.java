package com.capitole.consulting.technicalassessment.dao;

import com.capitole.consulting.technicalassessment.model.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceDao extends CrudRepository<Price, Integer> {

    @Query("select p from prices p where :applyDate between p.startDate and p.endDate and :productId = p.productId and :brandId = p.brandId")
    List<Price> getPrices(@Param("applyDate") LocalDateTime applyDate,
                                 @Param("productId") Integer productId,
                                 @Param("brandId") Integer brandId);

}
