package com.football.api;

import lombok.Getter;

@Getter
public class BusinessException extends Exception {
    private final ApiResponseCode errorCode;
    private final String errorMessage;

    public BusinessException(ApiResponseCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getMessage();
    }

    public BusinessException(ApiResponseCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public BusinessException(String message) {
        this(ApiResponseCode.BAD_REQUEST, message);
    }

}
