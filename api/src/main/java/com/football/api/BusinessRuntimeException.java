package com.football.api;

import lombok.Getter;

public class BusinessRuntimeException extends RuntimeException {

    private final ApiResponseCode apiResponseCode;

    @Getter
    private final String errorMessage;

    public BusinessRuntimeException(ApiResponseCode apiResponseCode) {
        super(apiResponseCode.getMessage());
        this.apiResponseCode = apiResponseCode;
        this.errorMessage = apiResponseCode.getMessage();

    }

    public BusinessRuntimeException(String message) {
        this(ApiResponseCode.BAD_REQUEST, message);
    }

    public BusinessRuntimeException(ApiResponseCode apiResponseCode, String message) {
        super(message);
        this.apiResponseCode = apiResponseCode;
        this.errorMessage = message;
    }

    public ApiResponseCode getErrorCode() {
        return apiResponseCode;
    }
}
