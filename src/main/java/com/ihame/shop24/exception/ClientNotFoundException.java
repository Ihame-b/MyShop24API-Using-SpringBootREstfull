package com.ihame.shop24.exception;


public class ClientNotFoundException extends  RuntimeException {

    public ClientNotFoundException(Long id){
        super( String.format(" Client %s not found in our records", id));
    }
}
