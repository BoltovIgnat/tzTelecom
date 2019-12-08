package com.example.easynotes.controller;

import com.example.easynotes.model.Orders;
import com.example.easynotes.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersRepository ordersRepository;

    @GetMapping("/")
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

}
