package com.patika.rentacarapp.controller;


import com.patika.rentacarapp.model.Reservation;
import com.patika.rentacarapp.model.User;
import com.patika.rentacarapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public void makeReservation(@RequestBody Reservation reservation) {
        reservationService.makeReservation(reservation.getUser(), reservation.getCar(), reservation.getStartDate(), reservation.getEndDate());
    }

    @DeleteMapping("/{id}")
    public void cancelReservation(@PathVariable Long id) {
        reservationService.cancelReservation(id);
    }

    @GetMapping("/user/{userId}")
    public List<Reservation> getUserReservations(@PathVariable Long userId) {
        return reservationService.getUserReservations(userId);
    }
}
