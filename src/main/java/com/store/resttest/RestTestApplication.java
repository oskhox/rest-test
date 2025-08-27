package com.store.resttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestTestApplication {

    //START: Kör igång, sen localhost:8080/fetch/all i postman
    public static void main(String[] args) {
        SpringApplication.run(RestTestApplication.class, args);
    }
}