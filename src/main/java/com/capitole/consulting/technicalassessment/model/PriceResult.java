package com.capitole.consulting.technicalassessment.model;

import com.capitole.consulting.technicalassessment.model.builders.impl.PriceResultBuilder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;

/**
 * This class will be returned from the getPrices method
 */

@JsonDeserialize(builder = PriceResultBuilder.class)
public class PriceResult {

    private Integer productId;
    private Integer brandId;
    private Double price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;

    private PriceResult() {}

    public PriceResult(PriceResultBuilder builder) {
        this.productId = builder.getProductId();
        this.brandId = builder.getBrandId();
        this.price = builder.getPrice();
        this.startDate = builder.getStartDate();
        this.endDate = builder.getEndDate();
        this.priceList = builder.getPriceList();
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Integer getPriceList() {
        return priceList;
    }
}
