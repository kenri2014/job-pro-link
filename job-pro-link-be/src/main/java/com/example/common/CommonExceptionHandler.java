package com.example.common;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description  例外処理の統一
 * @author ziqi
 * @since 2023-12-15
 */
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return Result.result(objectError.getDefaultMessage(),ResultCode.VALIDATE_ERROR);
    }

    @ExceptionHandler(APIException.class)
    public Result<String> APIExceptionHandler(APIException e) {
        return Result.result(e.getMessage(),ResultCode.VALIDATE_ERROR);
    }


}

