package com.example.easynotes.controller;

import com.example.easynotes.model.PointOfSale;
import com.example.easynotes.model.Tenants;
import com.example.easynotes.repository.PointOfSaleRepository;
import com.example.easynotes.repository.TenantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pointofsale")
public class PointofsaleController {

    @Autowired
    PointOfSaleRepository pointofsaleRepository;

    @GetMapping("/all")
    @CrossOrigin
    public List<PointOfSale> getAllPointOfSale() {
        return pointofsaleRepository.findAll();
    }

}
