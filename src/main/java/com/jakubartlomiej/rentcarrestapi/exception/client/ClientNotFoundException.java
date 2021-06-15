package com.jakubartlomiej.rentcarrestapi.exception.client;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(Long id) {
        super("Could not find client: "+id);
    }
}
