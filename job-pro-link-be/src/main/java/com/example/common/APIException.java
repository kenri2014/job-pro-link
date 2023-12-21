package com.example.common;

import lombok.Getter;
/**
 * @description  カスタム 例外クラス
 * @author ziqi
 * @since 2023-12-15
 */
@Getter
public class APIException extends RuntimeException {
    private String code;
    private String message;

    public APIException(StatusCode statusCode, String message) {
        super(message);
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
    }


    public APIException(String message) {
        super(message);
        this.code = ResultCode.VALIDATE_ERROR.getCode();
        this.message = message;
    }

}

