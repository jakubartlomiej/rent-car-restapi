package com.jakubartlomiej.rentcarrestapi.repository;

import com.jakubartlomiej.rentcarrestapi.entity.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {
}
