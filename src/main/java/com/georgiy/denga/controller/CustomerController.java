package com.georgiy.denga.controller;

import com.georgiy.denga.model.Customer;
import com.georgiy.denga.model.Ticket;
import com.georgiy.denga.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/buy/{id}")
    public ResponseEntity buyTicket(@PathVariable("id") Integer id, Customer customer) {
        try {
            Ticket ticket = customerService.buyTicket(id, customer);
            if (ticket == null) {
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("This ticket sold");
            }
        } catch (Exception e) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during buying");
        }
        return ResponseEntity.ok("you buy this ticket");
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

}
