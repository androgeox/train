package com.georgiy.denga.controller;

import com.georgiy.denga.model.Train;
import com.georgiy.denga.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping(value = "/{id}")
    public Train getTrainById(@PathVariable("id") Integer id) {
        return trainService.getTrainById(id);
    }
}
