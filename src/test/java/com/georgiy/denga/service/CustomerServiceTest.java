package com.georgiy.denga.service;

import com.georgiy.denga.model.Customer;
import com.georgiy.denga.model.Ticket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    @Qualifier("customer")
    CustomerService customerService;

    @Test
    public void buyTicketState() throws Exception {
        Customer customer = customerService.getCustomerById(1);
        Ticket ticket = customerService.buyTicket(1, customer);
        assertEquals("SOLD", ticket.getState());
    }

    @Test
    public void buyTicketCustomerNotNull() throws Exception {
        Customer customer = customerService.getCustomerById(2);
        Ticket ticket = customerService.buyTicket(2, customer);
        assertNotNull(ticket.getCustomer());
    }


}