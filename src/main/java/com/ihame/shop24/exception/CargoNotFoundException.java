package com.ihame.shop24.exception;

public class CargoNotFoundException extends  RuntimeException {

    public CargoNotFoundException(Long id){
        super( String.format(" Cargo %s not found in our records", id));
    }
}
