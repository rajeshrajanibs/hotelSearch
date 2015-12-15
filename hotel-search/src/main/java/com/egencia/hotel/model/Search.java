package com.egencia.hotel.model;

import org.springframework.data.annotation.Id;
/**
 * Created by jkurian on 12/10/15.
 */
public class Search {

    private String regionIds;
    private String fromDate;
    private String toDate;

    public Search() {

    }

    public Search(String regionIds, String fromDate, String toDate) {
        this.regionIds = regionIds;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    public String getRegionIds() {
        return regionIds;
    }

    public void setRegionIds(String regionIds) {
        this.regionIds = regionIds;
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
