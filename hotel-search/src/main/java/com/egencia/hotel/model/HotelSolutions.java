package com.egencia.hotel.model;

import java.util.List;

/**
 * Created by jkurian on 12/10/15.
 */
public class HotelSolutions {

    private int hotelCount;
    private Stay stay;
    private List<HotelSolution> hotelsolutions;

    private String regionId;

    public int getHotelCount() {
        return hotelCount;
    }

    public void setHotelCount(int hotelCount) {
        this.hotelCount = hotelCount;
    }

    public Stay getStay() {
        return stay;
    }

    public void setStay(Stay stay) {
        this.stay = stay;
    }

    public List<HotelSolution> getHotelsolutions() {
        return hotelsolutions;
    }

    public void setHotelsolutions(List<HotelSolution> hotelsolutions) {
        this.hotelsolutions = hotelsolutions;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }


}
