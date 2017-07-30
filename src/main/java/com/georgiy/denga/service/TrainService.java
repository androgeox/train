package com.georgiy.denga.service;

import com.georgiy.denga.model.Train;
import com.georgiy.denga.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public Train getTrainById(Integer id){
        return trainRepository.findOne(id);
    }
}
