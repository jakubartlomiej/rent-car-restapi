package com.jakubartlomiej.rentcarrestapi.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakubartlomiej.rentcarrestapi.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CarApiTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    public void shouldReturnStatus201() throws Exception {
        //given
        String url = "/cars";
        Car car = new Car();
        car.setId(1L);
        car.setBrand("Mazda");
        car.setModel("RX8");
        car.setDoor(2);
        car.setSeats(4);
        car.setYear(2020);
        String inputJson = objectMapper.writeValueAsString(car);
        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();
        //then
        assertEquals(mvcResult.getResponse().getStatus(),201);
    }

}