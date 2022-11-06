package com.example.billingservice;

import com.example.billingservice.entity.Passenger;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PassengerController {
    @Autowired
    private PassengerRepository billRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/passengers")
    public Passenger save(@RequestBody Passenger passenger) throws JsonProcessingException {
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        redisTemplate.opsForValue().set("passenger:" + passenger.getPassengerId(), ow.writeValueAsString(passenger));
        return billRepository.save(passenger);
    }

    @GetMapping("/passengers")
    public List<Passenger> getAll() {
//        redisTemplate.opsForValue().
        return billRepository.findAll();
    }

    @GetMapping("/passengers/{id}")
    public Passenger getOne(@PathVariable String id) throws JsonProcessingException {
        Object value = redisTemplate.opsForValue().get("passenger:" + id);
        if (value != null) {
            Passenger passenger = objectMapper.readValue((String) value, Passenger.class);
            System.out.println("object from Redis: "+passenger);
            return passenger;
        }
        return billRepository.findById(id).get();
    }
}
