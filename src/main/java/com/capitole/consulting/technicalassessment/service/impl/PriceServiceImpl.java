package com.capitole.consulting.technicalassessment.service.impl;

import com.capitole.consulting.technicalassessment.dao.PriceDao;
import com.capitole.consulting.technicalassessment.model.PriceResult;
import com.capitole.consulting.technicalassessment.service.IPriceService;
import com.capitole.consulting.technicalassessment.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceServiceImpl implements IPriceService {

    private PriceDao priceDao;

    @Autowired
    public PriceServiceImpl(PriceDao priceDao) {
        this.priceDao = priceDao;
    }

    @Override
    public List<PriceResult> getPrices(LocalDateTime applyDate, Integer productId, Integer brandId) {
        return Converter.convertPricesToPriceResult(priceDao.getPrices(applyDate, productId, brandId));
    }

}
