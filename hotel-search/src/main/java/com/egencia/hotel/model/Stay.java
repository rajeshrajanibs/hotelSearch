package com.egencia.hotel.model;

/**
 * Created by jkurian on 12/10/15.
 */
public class Stay {

    private String checkInDate;
    private String checkOutDate;

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
