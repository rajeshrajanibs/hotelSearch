package com.egencia.hotel.repository;

import com.egencia.hotel.model.HotelSolutions;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jkurian on 12/11/15.
 */
public interface HotelSolutionRepository extends MongoRepository<HotelSolutions,String> {
}
