package com.example.easynotes.repository;

import com.example.easynotes.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars, Long> {

}
