package com.jakubartlomiej.rentcarrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {

    private Long id;
    private LocalDate rentDay;
    private LocalDate rentEnd;
    private long clientId;
    private long carId;

}
