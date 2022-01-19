package com.capitole.consulting.technicalassessment.service.impl;

import com.capitole.consulting.technicalassessment.model.Price;
import com.capitole.consulting.technicalassessment.service.IPriceService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PriceServiceImpl implements IPriceService {

    @Override
    public List<Price> getPrices(Date applyDate, Integer productId, Integer brandId) {
        return null;
    }
}
