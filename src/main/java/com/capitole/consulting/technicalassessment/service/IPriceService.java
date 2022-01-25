package com.capitole.consulting.technicalassessment.service;

import com.capitole.consulting.technicalassessment.model.PriceResult;

import java.time.LocalDateTime;
import java.util.List;

public interface IPriceService {

    List<PriceResult> getPrices(LocalDateTime applyDate, Integer productId, Integer brandId);
}
