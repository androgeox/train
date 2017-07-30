package com.georgiy.denga.repository;

import com.georgiy.denga.model.Ticket;
import com.georgiy.denga.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query("select t from Ticket t where buyDate = :buyDate")
    List<Ticket> getTicketByDate(@Param("buyDate") Date buyDate);

    @Query("select t from Ticket t where state = :state")
    Set<Ticket> getAllForSell(@Param("state") String state);

    @Modifying
    @Query("select t from Ticket t where id = :id ")
    void deleteById(@Param("id") Integer id);
}
