package com.example.easynotes.controller;

import com.example.easynotes.model.Orders;
import com.example.easynotes.model.Tenants;
import com.example.easynotes.repository.OrdersRepository;
import com.example.easynotes.repository.TenantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    @Autowired
    TenantsRepository tenantsRepository;

    @GetMapping("/all")
    @CrossOrigin
    public List<Tenants> getAllOrders() {
        return tenantsRepository.findAll();
    }

}
