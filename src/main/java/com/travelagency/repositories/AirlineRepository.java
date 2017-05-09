package com.travelagency.repositories;

import com.travelagency.entities.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline,Long>{
    Airline findByName(String airlineName);
}
