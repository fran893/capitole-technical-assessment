package com.capitole.consulting.technicalassessment.model;

import com.capitole.consulting.technicalassessment.model.builders.impl.ResponseErrorBuilder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;

@JsonDeserialize(builder = ResponseErrorBuilder.class)
public class ResponseError {

    private LocalDateTime timeStamp;
    private String errorMessage;
    private Integer responseCode;

    private ResponseError() {}

    public ResponseError(ResponseErrorBuilder builder) {
        this.timeStamp = builder.getTimeStamp();
        this.errorMessage = builder.getErrorMessage();
        this.responseCode = builder.getResponseCode();
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
