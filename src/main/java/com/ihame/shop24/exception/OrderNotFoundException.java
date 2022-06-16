package com.ihame.shop24.exception;

public class OrderNotFoundException extends  RuntimeException {
    public OrderNotFoundException(Long id){
        super( String.format(" Order %s not found in our records", id));
    }

}
