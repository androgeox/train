package com.georgiy.denga.repository;

import com.georgiy.denga.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
