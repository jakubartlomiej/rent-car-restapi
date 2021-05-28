package com.jakubartlomiej.rentcarrestapi.exception;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(Long id) {
        super("Could not find car: " + id);
    }
}
