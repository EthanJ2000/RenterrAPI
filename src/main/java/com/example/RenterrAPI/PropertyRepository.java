package com.example.RenterrAPI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property,Long>  {
}
