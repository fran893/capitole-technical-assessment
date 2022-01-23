package com.capitole.consulting.technicalassessment.utils;

import com.capitole.consulting.technicalassessment.model.Price;
import com.capitole.consulting.technicalassessment.model.PriceResult;
import com.capitole.consulting.technicalassessment.model.builders.impl.PriceResultBuilder;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<PriceResult> convertPricesToPriceResult(List<Price> pricesList) {
        List<PriceResult> result = new ArrayList<>();
        pricesList.forEach(price -> {
            result.add(new PriceResultBuilder()
                    .withProductId(price.getProductId())
                    .withBrandId(price.getBrandId())
                    .withPrice(price.getPrice())
                    .withStartDate(price.getStartDate())
                    .withEndDate(price.getEndDate())
                    .withPriceList(price.getPriceList()).build()
            );
        });
        return result;
    }
}
