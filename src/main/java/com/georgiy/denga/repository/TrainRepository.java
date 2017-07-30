package com.georgiy.denga.repository;

import com.georgiy.denga.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Integer> {
}
