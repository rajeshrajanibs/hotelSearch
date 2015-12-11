package com.egencia.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class HotelSearchApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HotelSearchApplication.class, args);
    }
}
