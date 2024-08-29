package com.patika.rentacarapp.repository;

import com.patika.rentacarapp.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}

