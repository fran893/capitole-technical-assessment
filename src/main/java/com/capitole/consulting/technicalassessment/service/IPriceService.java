package com.capitole.consulting.technicalassessment.service;

import com.capitole.consulting.technicalassessment.model.Price;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IPriceService {

    List<Price> getPrices(LocalDateTime applyDate, Integer productId, Integer brandId);
}
