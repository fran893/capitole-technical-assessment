package com.capitole.consulting.technicalassessment.service.impl;

import com.capitole.consulting.technicalassessment.dao.PriceDao;
import com.capitole.consulting.technicalassessment.model.Price;
import com.capitole.consulting.technicalassessment.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class PriceServiceImpl implements IPriceService {

    private PriceDao priceDao;

    @Autowired
    public PriceServiceImpl(PriceDao priceDao) {
        this.priceDao = priceDao;
    }

    @Override
    public List<Price> getPrices(LocalDateTime applyDate, Integer productId, Integer brandId) {
        return priceDao.getPrices(applyDate, productId, brandId);
    }

}
