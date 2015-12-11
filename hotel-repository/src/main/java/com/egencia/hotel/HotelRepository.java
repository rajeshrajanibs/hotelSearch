package com.egencia.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by anambiath on 12/11/15.
 */
@SpringBootApplication
public class HotelRepository extends SpringBootServletInitializer{
    public static void main(String[] args){
        SpringApplication.run(HotelRepository.class,args);
    }
}
