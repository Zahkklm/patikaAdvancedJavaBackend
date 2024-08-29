package com.patika.rentacarapp.controller;

import com.patika.rentacarapp.model.Car;
import com.patika.rentacarapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/search")
    public List<Car> searchCars(@RequestParam String type,
                                @RequestParam LocalDate startDate,
                                @RequestParam LocalDate endDate) {
        return carService.searchCars(type, startDate, endDate);
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @PutMapping
    public void updateCar(@RequestBody Car car) {
        carService.updateCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}
