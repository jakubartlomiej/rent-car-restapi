package com.jakubartlomiej.rentcarrestapi.exception.rent;

public class RentNotFoundException extends RuntimeException {
    public RentNotFoundException(Long id) {
        super("Could not find rent: "+id);
    }
}
