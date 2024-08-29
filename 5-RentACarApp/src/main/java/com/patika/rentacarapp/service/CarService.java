package com.patika.rentacarapp.service;

import com.patika.rentacarapp.model.Car;
import com.patika.rentacarapp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> searchCars(String type, LocalDate startDate, LocalDate endDate) {
    //    return carRepository.findByTypeAndAvailabilityStartBeforeAndAvailabilityEndAfter(type, startDate, endDate);
          return carRepository.findByType(type);

    }

    public Car getCarDetails(Long carId) {
        return carRepository.findById(carId).orElse(null);
    }

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public void updateCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}
