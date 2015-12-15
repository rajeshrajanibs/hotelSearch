package com.egencia.hotel.repository;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

public class HotelSearchConnectionConfig {

    public @Bean
    MongoDbFactory mongoDbFactory()throws Exception{
        return new SimpleMongoDbFactory(new MongoClient("192.168.71.44" , 27017 ),"test");
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception{
        MongoTemplate mongoTemplate= new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
}
