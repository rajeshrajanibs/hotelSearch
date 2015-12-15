package com.egencia.hotel.repository;

import com.egencia.hotel.model.HotelSolutions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("hotelSearchDao")
public class HotelSearchDaoImpl implements HotelSearchDao {


    @Override
    public HotelSolutions saveHotelSolutions(MongoOperations mongoOperations,HotelSolutions hotelSolutions) {

            mongoOperations.save(hotelSolutions);
            Query query = new Query(Criteria.where("regionId").is(hotelSolutions.getRegionId()).and("stay.checkInDate").
                    is(hotelSolutions.getStay().getCheckInDate()).and("stay.checkOutDate").is(hotelSolutions.getStay().
                        getCheckOutDate()));
            HotelSolutions savedSolutions;
            savedSolutions = mongoOperations.findOne(query, HotelSolutions.class);
            return savedSolutions;
    }

    @Override
    public HotelSolutions findHotelSolutions(MongoOperations mongoOperations,String regionId,String frmDate,String toDate) {
            Query query = new Query(Criteria.where("regionId").is(regionId).and("stay.checkInDate").
                                                is(frmDate).and("stay.checkOutDate").is(toDate));
            HotelSolutions savedSolutions;
            savedSolutions = mongoOperations.findOne(query, HotelSolutions.class);
            return savedSolutions;
    }


}
