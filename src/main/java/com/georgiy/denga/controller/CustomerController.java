package com.georgiy.denga.controller;


import com.georgiy.denga.model.Ticket;
import com.georgiy.denga.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping(value = "/buy/{id}")
  public ResponseEntity buyTicket(@PathVariable("id") Integer id) {
    customerService.buyTicket(id);
    return ResponseEntity.ok("билет куплен");
  }

}
