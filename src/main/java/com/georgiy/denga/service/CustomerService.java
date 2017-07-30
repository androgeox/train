package com.georgiy.denga.service;

import com.georgiy.denga.model.Customer;
import com.georgiy.denga.model.Ticket;
import com.georgiy.denga.repository.CustomerRepository;
import com.georgiy.denga.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Qualifier("customer")
public class CustomerService {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Service for buying ticket.
     *
     * @param id       of ticket
     * @param customer
     * @return ticket
     */
    public Ticket buyTicket(Integer id, Customer customer) {
        Ticket ticket = ticketService.getTicketById(id);
        if (ticket.getState().equals(Ticket.TicketState.getForSell())) {
            ticket.setCustomer(customerRepository.findOne(customer.getId()));
            ticket.setState(Ticket.TicketState.getSold());
        } else {
            return null;
        }
        return ticket;
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findOne(id);
    }
}
