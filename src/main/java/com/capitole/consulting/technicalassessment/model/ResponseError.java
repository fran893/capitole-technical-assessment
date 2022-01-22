package com.capitole.consulting.technicalassessment.model;

import java.time.LocalDateTime;

public class ResponseError {

    private LocalDateTime timeStamp;
    private String errorMessage;
    private Integer responseCode;

    public ResponseError(LocalDateTime timeStamp, String errorMessage, Integer responseCode) {
        this.timeStamp = timeStamp;
        this.errorMessage = errorMessage;
        this.responseCode = responseCode;
    }

    public ResponseError() {}

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }
}
