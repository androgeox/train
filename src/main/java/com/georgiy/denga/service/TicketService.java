package com.georgiy.denga.service;

import com.georgiy.denga.DateConverter;
import com.georgiy.denga.model.Ticket;
import com.georgiy.denga.repository.TicketRepository;
import com.georgiy.denga.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    /**
     * Get ticket by date
     *
     * @param date
     * @return
     */
    public List<Ticket> getTicketByDate(String date) {
        try {
            List<Ticket> tickets = ticketRepository.getTicketByDate(DateConverter.toUtilDate(date));
            if (tickets.size() == 0) {
                throw new NullPointerException("ticket list is null");
            }
            return tickets;
        } catch (ParseException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Get all tickets where state = FORSELL
     *
     * @param state
     * @return
     */
    public Set<Ticket> getAllForSell(String state) {
        return ticketRepository.getAllForSell(state);
    }

    public Ticket getTicketById(Integer id) {
        return ticketRepository.findOne(id);
    }

    /**
     * Add and update Ticket
     *
     * @param ticket
     */
    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    /**
     * Delete ticket if id !=null
     *
     * @param id
     */
    public void deleteTicket(Integer id) {
        if (id != null) {
            ticketRepository.deleteById(id);
        } else {
            throw new NullPointerException();
        }
    }
}
