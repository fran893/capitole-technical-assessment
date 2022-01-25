package com.capitole.consulting.technicalassessment.controller;

import com.capitole.consulting.technicalassessment.model.PriceResult;
import com.capitole.consulting.technicalassessment.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PriceController {

    private IPriceService priceService;

    @Autowired
    public PriceController(IPriceService priceService){
        this.priceService = priceService;
    }

    @GetMapping("/getPrices")
    public ResponseEntity<List<PriceResult>> getPrices(@RequestParam("applyDate")
                                            @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime applyDate,
                                                      @RequestParam("productId") Integer productId,
                                                      @RequestParam("brandId") Integer brandId) {
        List<PriceResult> prices = priceService.getPrices(applyDate, productId, brandId);
        if (!prices.isEmpty()){
            return new ResponseEntity<>(prices, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException();
        }
    }

}
