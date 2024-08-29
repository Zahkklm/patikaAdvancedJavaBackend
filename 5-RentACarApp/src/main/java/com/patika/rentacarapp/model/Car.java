package com.patika.rentacarapp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private BigDecimal dailyPrice;

    @Column(nullable = false)
    private LocalDate availabilityStart;

    @Column(nullable = false)
    private LocalDate availabilityEnd;

    @Column
    private String extraServices;

    // Getters and setters
}
