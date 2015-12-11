package com.egencia.hotel.service;

import com.egencia.hotel.model.HotelSolutions;

/**
 * Created by jkurian on 12/11/15.
 */
public interface HotelSearchService {

    public HotelSolutions search(String hotelID, String frmDate, String toDate);
}
