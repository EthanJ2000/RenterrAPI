package com.example.RenterrAPI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends PagingAndSortingRepository<Property,Long> {
    Property findByAddress(String address);
}
