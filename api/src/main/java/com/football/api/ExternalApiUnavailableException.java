package com.football.api;

import lombok.Getter;

@SuppressWarnings("unused")
@Getter
public class ExternalApiUnavailableException extends BusinessException {
    public ExternalApiUnavailableException(String message) {
        super(ApiResponseCode.EXTERNAL_API_UNAVAILABLE, message);
    }
}
