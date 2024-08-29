package com.patika.rentacarapp.service;


import com.patika.rentacarapp.model.Car;
import com.patika.rentacarapp.model.Reservation;
import com.patika.rentacarapp.model.User;
import com.patika.rentacarapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public void makeReservation(User user, Car car, LocalDate startDate, LocalDate endDate) {
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setCar(car);
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservationRepository.save(reservation);
    }

    public void cancelReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    public List<Reservation> getUserReservations(Long userId) {
        return reservationRepository.findByUserId(userId);
    }
}

