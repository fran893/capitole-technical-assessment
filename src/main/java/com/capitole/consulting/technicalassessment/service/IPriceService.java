package com.capitole.consulting.technicalassessment.service;

import com.capitole.consulting.technicalassessment.model.Price;

import java.util.Date;
import java.util.List;

public interface IPriceService {

    public List<Price> getPrices(Date applyDate, Integer productId, Integer brandId);
}
