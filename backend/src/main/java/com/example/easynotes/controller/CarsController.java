package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Cars;
import com.example.easynotes.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    CarsRepository carsRepository;

    @GetMapping("/all")
    @CrossOrigin
    public List<Cars> getAllCars() {
        return carsRepository.findAll();
    }

}
