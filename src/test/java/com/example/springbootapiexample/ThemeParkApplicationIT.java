package com.example.springbootapiexample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ThemeParkApplicationIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllRides() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/ride")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getRide() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/ride/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void returnsNotFoundForInvalidSingleRide() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/ride/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }


    @Test
    void createRide() throws Exception{
        String newRide = "{\"name\":\"Monorail\",\"description\":\"Sedated traveling ride.\",\"thrillFactor\":2,\"vomitFactor\":1}";
        mockMvc.perform(MockMvcRequestBuilders.post("/ride")
        .contentType(MediaType.APPLICATION_JSON)
        .content(newRide)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();
    }

}
