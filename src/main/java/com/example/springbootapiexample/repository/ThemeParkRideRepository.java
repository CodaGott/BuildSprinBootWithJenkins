package com.example.springbootapiexample.repository;

import com.example.springbootapiexample.model.ThemePArkRide;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeParkRideRepository extends CrudRepository<ThemePArkRide, Long> {
    List<ThemePArkRide> findByName(String name);
}
