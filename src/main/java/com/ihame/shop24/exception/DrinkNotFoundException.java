package com.ihame.shop24.exception;
public class DrinkNotFoundException extends  RuntimeException {

    public DrinkNotFoundException(Long id){
        super( String.format(" Drink %s not found in our records", id));
    }
}
