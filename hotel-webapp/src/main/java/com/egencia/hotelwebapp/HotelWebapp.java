package com.egencia.hotelwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created with IntelliJ IDEA.
 * User: rrajan
 * Date: 12/10/15
 * Time: 2:12 AM
 * To change this template use File | Settings | File Templates.
 */

@SpringBootApplication
public class HotelWebapp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HotelWebapp.class, args);
    }
}
