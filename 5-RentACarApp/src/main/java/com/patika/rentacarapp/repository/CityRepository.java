package com.patika.rentacarapp.repository;

import com.patika.rentacarapp.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
