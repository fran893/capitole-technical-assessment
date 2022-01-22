package com.capitole.consulting.technicalassessment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "prices")
@Table(name = "prices", schema = "flyway")
public class Price implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "priceid")
    private Integer priceId;
    @Column(name = "brandid")
    private Integer brandId;
    @Column(name = "startdate")
    private LocalDateTime startDate;
    @Column(name = "enddate")
    private LocalDateTime endDate;
    @Column(name = "pricelist")
    private Integer priceList;
    @Column(name = "productid")
    private Integer productId;
    private Integer priority;
    private Double price;
    private String curr;

    public Price(){}

    public Price(Integer priceId, Integer brandId, LocalDateTime startDate, LocalDateTime endDate, Integer priceList, Integer productId, Integer priority, Double price, String curr) {
        this.priceId = priceId;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }
}
