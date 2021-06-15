package com.jakubartlomiej.rentcarrestapi.exception.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClientNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String clientNotFoundHandle(ClientNotFoundException ex) {
        return ex.getMessage();
    }
}
