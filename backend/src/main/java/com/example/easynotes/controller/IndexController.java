package com.example.easynotes.controller;


import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Cars;
import com.example.easynotes.model.Orders;
import com.example.easynotes.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    OrdersRepository ordersRepository;

    @GetMapping("/sayhello2/")
    public Optional<Orders> sayHello2() {
        //return "logResults("+convertWithIteration(carsStorage)+")";
        return ordersRepository.findById(1);
        //return ;
    }

    @GetMapping("/deleteOrder/{id}")
    @CrossOrigin
    public String deleteOrder(@PathVariable(value = "id") Integer orderId) {
        Orders order = ordersRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));

        ordersRepository.delete(order);

        return "Удалено";
    }

    @PostMapping("/createOrder/")
    @CrossOrigin
    public Orders createOrders(@RequestBody Orders orders) {
        return ordersRepository.save(orders);
    }

    @GetMapping
    @CrossOrigin
    public String sayHello() {

        return convertWithIteration(ordersRepository.findAll());

    }

    @RequestMapping(value="/editOrder/{id}", method = RequestMethod.POST)
    @CrossOrigin
    public Orders updateNote(@PathVariable(value = "id") Integer orderId,
                           @RequestBody Orders noteDetails) {

        Orders order = ordersRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));

        order.setCar(noteDetails.getCar());
        order.setTenant(noteDetails.getTenant());
        order.setPointofsale(noteDetails.getPointofsale());
        order.setRentalDateOn(noteDetails.getRentalDateOn());
        order.setRentalDateOff(noteDetails.getRentalDateOff());
        order.setAmount(noteDetails.getAmount());

        Orders updatedNote = ordersRepository.save(order);
        return updatedNote;
    }
    
    public String convertWithIteration(List<Orders> map) {
        StringBuilder mapAsString = new StringBuilder("{");

        mapAsString.append("\"data\": ");
        mapAsString.append("[");

        for (Orders order : map) {
            mapAsString.append("{");

            Cars car = order.getCar();
            mapAsString.append("\"id\": \" " + order.getId() + " \" , ");
            mapAsString.append("\"name\": \" " + car.getName() + " \" , ");
            mapAsString.append("\"nuberCar\": \" " + car.getNumberCar() + " \" , ");
            mapAsString.append("\"tenant\": \" " + order.getTenant().getName() + " \" , ");
            mapAsString.append("\"pointofsale\": \" " + order.getPointofsale().getName() + " \" , ");
            mapAsString.append("\"amount\": \" " + order.getAmount() + " \" , ");
            mapAsString.append("\"rentalDateOn\": \" " + order.getRentalDateOn() + " \" , ");
            mapAsString.append("\"rentalDateOff\": \" " + order.getRentalDateOff() + " \" , ");
            mapAsString.append("\"buttons\": \" <a rowid='" + order.getId() +"' role='button' class='ibcbtn-edit btn btn-success' data-target='#editModal'>Редактировать</a> <a rowid='" + order.getId() +"' role='button' class='ibcbtn-delete btn btn-danger'>Удалить</a> \" ");
            mapAsString.append("},");
        }

        mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}]}");
        return mapAsString.toString();
    }
}
