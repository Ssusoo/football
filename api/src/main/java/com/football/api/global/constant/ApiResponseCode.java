package com.football.api.global.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ApiResponseCode {
    OK(200, "R20000", "정상"),
    BAD_REQUEST(400, "R40000", "비정상적인 요청입니다."),
    EXTERNAL_API_UNAVAILABLE(503, "R50301", "서버가 요청을 처리할 준비가 되지 않았습니다.")
    ;

    private final int status;
    private final String code;
    private final String message;

    ApiResponseCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
