package com.egencia.hotel.model;

import org.springframework.data.annotation.Id;

/**
 * Created by djoseph on 12/10/15.
 */
public class Solution {

    @Id
    public String id;
    public String locationName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }



}
