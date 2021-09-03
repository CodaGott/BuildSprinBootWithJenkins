package com.example.springbootapiexample.controller;

import com.example.springbootapiexample.model.ThemePArkRide;
import com.example.springbootapiexample.repository.ThemeParkRideRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class ThemeParkRideController {

    private ThemeParkRideRepository themeParkRideRepository;

    public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository) {
        this.themeParkRideRepository = themeParkRideRepository;
    }

     @GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ThemePArkRide> getRides(){
        return themeParkRideRepository.findAll();
     }

     @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemePArkRide getARide(@PathVariable Long id){
        return themeParkRideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
     }

     @PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemePArkRide createRide(@Valid @RequestBody ThemePArkRide themePArkRide){
        return themeParkRideRepository.save(themePArkRide);
     }

}
