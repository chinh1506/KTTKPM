package com.example.circuitbreaker;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/passengers")
    public List<Object> findAllPassenger() {
//        System.out.println("Goi lai: " + System.currentTimeMillis());
//        List<Object> os = restTemplate.getForObject("http://localhost:8081/passengers", List.class);
        for (int i = 0; i < 20; i++) {
            findAll();
        }
        return null;
    }
    @CircuitBreaker(name = "passenger-service", fallbackMethod = "subscribesFallbackMethod")
    public List<Object> findAll(){
        System.out.println("Goi lai: " + System.currentTimeMillis());
        List<Object> os = restTemplate.getForObject("http://localhost:8081/passengers", List.class);
        return os;
    }
    public List<Object> subscribesFallbackMethod(Exception e) {
//        e.printStackTrace();
        System.out.println("Loi");
        return Arrays.asList("Lỗi hehe");
    }


}
