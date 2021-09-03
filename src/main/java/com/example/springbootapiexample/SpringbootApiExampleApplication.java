package com.example.springbootapiexample;

import com.example.springbootapiexample.model.ThemePArkRide;
import com.example.springbootapiexample.repository.ThemeParkRideRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootApiExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApiExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ThemeParkRideRepository repository){
        return (args) -> {
            repository.save(new ThemePArkRide("RollerCoaster", "Train ride that speeds you along", 5, 3));
            repository.save(new ThemePArkRide("Log flume", "Boat ride with plenty of splashes", 3, 2));
            repository.save(new ThemePArkRide("Teacups", "Spinning ride in a giant tea-cup", 2, 4));
        };
    }
}
