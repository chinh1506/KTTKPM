package com.example.apigateway1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RestController;

//@EnableConfigServer
@SpringBootApplication
public class ApiGateway1Application {
    public static void main(String[] args) {
        SpringApplication.run(ApiGateway1Application.class, args);
    }


}
