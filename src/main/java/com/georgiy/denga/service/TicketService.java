package com.georgiy.denga.service;

import com.georgiy.denga.model.Ticket;
import com.georgiy.denga.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

  @Autowired
  private TicketRepository ticketRepository;

//  @PersistenceContext(name = "entityManager")
//  private EntityManager em;

  public List<Ticket> getTicketByDate(Date date){
    return ticketRepository.getTicketByDate(date);
  }

//  public List<Ticket> getAllTicketForSell(){
//    return ticketRepository.getAllForSell();
//  }

  public Ticket getTicketById(Integer id) {
    return ticketRepository.findOne(id);
  }
}
