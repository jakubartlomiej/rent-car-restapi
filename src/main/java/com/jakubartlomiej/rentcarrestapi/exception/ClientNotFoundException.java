package com.jakubartlomiej.rentcarrestapi.exception;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(Long id) {
        super("Could not find client: "+id);
    }
}
