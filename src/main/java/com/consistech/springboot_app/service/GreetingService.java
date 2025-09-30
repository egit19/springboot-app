package com.consistech.springboot_app.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreetingMessage() {
        return "Selamat datang di aplikasi Spring Boot!";
    }
}
