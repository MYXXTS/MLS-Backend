package com.myxxts.mls.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myxxts.mls.enums.HttpCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {
    private final Integer code;
    private final String message;
    private T data;

    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseResult<?> success() {
        return new ResponseResult<>(
                HttpCodeEnum.SUCCESS.getCode(),
                HttpCodeEnum.SUCCESS.getMessage()
        );
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(
                HttpCodeEnum.SUCCESS.getCode(),
                HttpCodeEnum.SUCCESS.getMessage(),
                data
        );
    }

    public static ResponseResult<?> error(String message) {
        return new ResponseResult<>(
                HttpCodeEnum.ERROR.getCode(),
                message
        );
    }

    public static ResponseResult<?> error(Integer code, String message) {
        return new ResponseResult<>(
                code,
                message
        );
    }
}
