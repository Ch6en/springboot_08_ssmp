package com.chen.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        e.printStackTrace();
        return new Result("数据异常，请稍后再试");
    }

}
