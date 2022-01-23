package com.capitole.consulting.technicalassessment.model.builders.impl;

import com.capitole.consulting.technicalassessment.model.ResponseError;
import com.capitole.consulting.technicalassessment.model.builders.IBuilder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDateTime;

@JsonPOJOBuilder
public class ResponseErrorBuilder implements IBuilder {

    private LocalDateTime timeStamp;
    private String errorMessage;
    private Integer responseCode;

    public ResponseErrorBuilder() {}

    public ResponseErrorBuilder withTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public ResponseErrorBuilder withErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public ResponseErrorBuilder withResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    @Override
    public ResponseError build() {
        return new ResponseError(this);
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Integer getResponseCode() {
        return responseCode;
    }
}
