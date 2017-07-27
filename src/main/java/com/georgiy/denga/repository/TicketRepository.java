package com.georgiy.denga.repository;


import com.georgiy.denga.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
  @Query("select t from Ticket t where buyDate = :buyDate")
  List<Ticket> getTicketByDate(Date buyDate);

//  @Query("select t from Ticket t where state = :state")
//  List<Ticket> getAllForSell();
}
