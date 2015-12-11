package com.egencia.hotel.model;

import org.springframework.data.annotation.Id;
/**
 * Created by jkurian on 12/10/15.
 */
public class Search {

    private String hotelIds;
    private String fromDate;
    private String toDate;

    public Search() {

    }

    public Search(String hotelIds, String fromDate, String toDate) {
        this.hotelIds = hotelIds;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    public String getHotelIds() {
        return hotelIds;
    }

    public void setHotelIds(String hotelIds) {
        this.hotelIds = hotelIds;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }


}
