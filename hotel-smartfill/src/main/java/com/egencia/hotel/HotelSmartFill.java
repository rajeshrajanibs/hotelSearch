package com.egencia.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import java.lang.String;

@SpringBootApplication
public class HotelSmartFill extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(HotelSmartFill.class, args);
    }

}