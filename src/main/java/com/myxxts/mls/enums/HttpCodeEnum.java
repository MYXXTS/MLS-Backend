package com.myxxts.mls.enums;

import lombok.Getter;

@Getter
public enum HttpCodeEnum {
    SUCCESS(200, "Success"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    ERROR(500),
    USER_LOGIN_ERROR(5001, "login defeat"),
    PARAMETER_EXCEPTION(5002, "parameter exception"),
    REQUEST_METHOD_ERROR(5003, "request method error"),
    USER_REGISTER_ERROR(5004, "register defeat");

    private final Integer code;
    private final String message;
    HttpCodeEnum(Integer code) {
        this.code = code;
        this.message = null;
    }
    HttpCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}