package com.jakubartlomiej.rentcarrestapi.repository;

import com.jakubartlomiej.rentcarrestapi.entity.Rent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends PagingAndSortingRepository<Rent, Long> {
    Iterable<Rent> findByClientId(Long id);
}
