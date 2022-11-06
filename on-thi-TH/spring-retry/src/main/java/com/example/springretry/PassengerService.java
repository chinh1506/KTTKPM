package com.example.springretry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;
import java.util.Date;

@Service
public class PassengerService {
    @Autowired
    private RestTemplate restTemplate;

    @Retryable(value = Exception.class, maxAttempts = 5, backoff = @Backoff(delay = 10000))
    public Passenger save(Passenger passenger) {
        System.out.println("retry:"+ (new Date()).getTime());
        return restTemplate.postForObject("http://localhost:8081/passemgers", passenger, Passenger.class);
    }
}
