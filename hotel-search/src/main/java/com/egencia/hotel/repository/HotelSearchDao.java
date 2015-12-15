package com.egencia.hotel.repository;

import com.egencia.hotel.model.HotelSolutions;
import org.springframework.data.mongodb.core.MongoOperations;


public interface HotelSearchDao {

    public HotelSolutions saveHotelSolutions(MongoOperations mongoOperations,HotelSolutions hotelSolutions);
    public HotelSolutions findHotelSolutions(MongoOperations mongoOperations,String regionId,String frmDate,String toDate);
}
