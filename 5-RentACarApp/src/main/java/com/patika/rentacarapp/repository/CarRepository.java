package com.patika.rentacarapp.repository;

import com.patika.rentacarapp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByTypeAndAvailabilityStartBeforeAndAvailabilityEndAfter(String type, LocalDate startDate, LocalDate endDate);
    List<Car> findByType(String type);
}

