package com.egencia.hotel.repository;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by anambiath on 12/10/15.
 */
public class HotelReviewConnectionConfig {

    public @Bean
    MongoDbFactory mongoDbFactory()throws Exception{
         return new SimpleMongoDbFactory(new MongoClient("192.168.71.98" , 27017 ),"test");
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception{
        MongoTemplate mongoTemplate= new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
}
