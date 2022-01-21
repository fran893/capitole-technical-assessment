package com.capitole.consulting.technicalassessment.controller;

import com.capitole.consulting.technicalassessment.model.Price;
import com.capitole.consulting.technicalassessment.model.PriceResult;
import com.capitole.consulting.technicalassessment.service.IPriceService;
import com.capitole.consulting.technicalassessment.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
public class PriceController {

    private IPriceService priceService;

    @Autowired
    public PriceController(IPriceService priceService){
        this.priceService = priceService;
    }

    @GetMapping("/getPrices")
    @ResponseBody
    public List<PriceResult> getPrices(@RequestParam("applyDate")
                                            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime applyDate,
                                       @RequestParam("productId") Integer productId,
                                       @RequestParam("brandId") Integer brandId) {
        List<Price> prices = priceService.getPrices(applyDate, productId, brandId);
        return Converter.convertPricesToResult(prices);
    }

}
