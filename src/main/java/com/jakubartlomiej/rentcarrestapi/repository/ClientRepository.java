package com.jakubartlomiej.rentcarrestapi.repository;

import com.jakubartlomiej.rentcarrestapi.entity.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
}
