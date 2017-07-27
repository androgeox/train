package com.georgiy.denga.controller;

import com.georgiy.denga.model.Ticket;
import com.georgiy.denga.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

  @Autowired
  private TicketService ticketService;

  @GetMapping(value = "/date/{date}")
  public ResponseEntity getTicketByDate(@PathVariable Date date){
    List<Ticket> ticketByDate = ticketService.getTicketByDate(date);
    return ResponseEntity.ok(ticketByDate);
  }

  @GetMapping(value = "/{id}")
  public Ticket getTicketById(@PathVariable("id") Integer id){
    return  ticketService.getTicketById(id);
  }
}
