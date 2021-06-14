package com.jakubartlomiej.rentcarrestapi.dto;

import java.time.LocalDate;

public class RentClientCarDto {

    private Long id;
    private LocalDate rentDay;
    private LocalDate rentEnd;
    private long clientId;
    private long carId;

}
