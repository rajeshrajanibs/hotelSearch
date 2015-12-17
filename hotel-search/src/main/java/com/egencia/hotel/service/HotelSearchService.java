package com.egencia.hotel.service;

import com.egencia.hotel.model.HotelSolution;
import com.egencia.hotel.model.HotelSolutions;

/**
 * Created by jkurian on 12/11/15.
 */
public interface HotelSearchService {

    public HotelSolutions search(String regionId, String frmDate, String toDate);
    public HotelSolution searchByHotelId(String regionId,String hotelId,String frmDate, String toDate);
}
