package com.georgiy.denga.controller;

import com.georgiy.denga.model.Ticket;
import com.georgiy.denga.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    /**
     * Get ticket by date, string type ddMMyyyy
     *
     * @param date
     * @return
     */
    @GetMapping(value = "/date/{date}")
    public ResponseEntity getTicketByDate(@PathVariable("date") String date) {
        List<Ticket> tickets = null;
        try {
            tickets = ticketService.getTicketByDate(date);
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("list of ticket on this date is empty");
        } catch (IllegalArgumentException i) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("check inserted date");
        }
        return ResponseEntity.ok(tickets);
    }

    @GetMapping(value = "/{id}")
    public Ticket getTicketById(@PathVariable("id") Integer id) {
        return ticketService.getTicketById(id);
    }

    @GetMapping(value = "/all/{state}")
    public Set<Ticket> getAllForSell(@PathVariable String state) {
        return ticketService.getAllForSell(state);
    }

    @PostMapping(value = "/add")
    public ResponseEntity addTicket(@RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
        return ResponseEntity.ok("Ticket has been added");
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        try {
            ticketService.deleteTicket(id);
        } catch (Exception e) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ticket not exist");
        }
        return ResponseEntity.ok("Ticket has been deleted");
    }
}
