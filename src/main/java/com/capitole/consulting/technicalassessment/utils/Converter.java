package com.capitole.consulting.technicalassessment.utils;

import com.capitole.consulting.technicalassessment.model.Price;
import com.capitole.consulting.technicalassessment.model.PriceResult;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<PriceResult> convertPricesToPriceResult(List<Price> pricesList) {
        List<PriceResult> result = new ArrayList<>();
        pricesList.forEach(price -> {
            result.add(new PriceResult() {{
                setPrice(price.getPrice());
                setBrandId(price.getBrandId());
                setProductId(price.getProductId());
                setPriceList(price.getPriceList());
                setEndDate(price.getEndDate());
                setStartDate(price.getStartDate());
            }});
        });
        return result;
    }
}
