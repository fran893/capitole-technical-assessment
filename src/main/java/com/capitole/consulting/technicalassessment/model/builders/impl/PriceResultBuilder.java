package com.capitole.consulting.technicalassessment.model.builders.impl;

import com.capitole.consulting.technicalassessment.model.PriceResult;
import com.capitole.consulting.technicalassessment.model.builders.IBuilder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDateTime;

@JsonPOJOBuilder
public class PriceResultBuilder implements IBuilder {

    private Integer productId;
    private Integer brandId;
    private Double price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;

    public PriceResultBuilder() {}

    public PriceResultBuilder withProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public PriceResultBuilder withBrandId(Integer brandId) {
        this.brandId = brandId;
        return this;
    }

    public PriceResultBuilder withPrice(Double price) {
        this.price = price;
        return this;
    }

    public PriceResultBuilder withStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public PriceResultBuilder withEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public PriceResultBuilder withPriceList(Integer priceList) {
        this.priceList = priceList;
        return this;
    }

    @Override
    public PriceResult build() {
        return new PriceResult(this);
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
