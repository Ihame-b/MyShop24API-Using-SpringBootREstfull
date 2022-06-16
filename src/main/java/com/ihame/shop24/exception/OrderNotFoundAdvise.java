package com.ihame.shop24.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class OrderNotFoundAdvise {

    @ResponseBody
    @ExceptionHandler(CargoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String cargoNotFoundHandler( CargoNotFoundException ex){
        return ex.getMessage();
    }
}
