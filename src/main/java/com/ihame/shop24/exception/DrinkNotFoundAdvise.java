package com.ihame.shop24.service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class DrinkNotFoundAdvise {

    @ResponseBody
    @ExceptionHandler(DrinkNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
   String drinkNotFoundHandler( DrinkNotFoundException ex){
     return ex.getMessage();
    }
}
