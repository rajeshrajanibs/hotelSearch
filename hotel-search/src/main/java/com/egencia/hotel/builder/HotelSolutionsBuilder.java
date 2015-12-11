package com.egencia.hotel.builder;

import com.egencia.hotel.model.HotelSolutions;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Created by jkurian on 12/11/15.
 */
public class HotelSolutionsBuilder {

    public static HotelSolutions build(JsonNode jsonSolution) {
        HotelSolutions hotelSolutions = new HotelSolutions();
        hotelSolutions.setHotelCount(jsonSolution.get("HotelCount").asInt());
        return hotelSolutions;
    }
}
