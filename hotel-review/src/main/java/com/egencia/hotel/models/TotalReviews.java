package com.egencia.hotel.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by anambiath on 12/16/15.
 */
@Document(collection = "reviews")
public class TotalReviews {

    @Id
    private String id;
    private List<ReviewMB> reviewMBList;
    private String hotelId;

    public List<ReviewMB> getReviewMBList() {
        return reviewMBList;
    }

    public void setReviewMBList(List<ReviewMB> reviewMBList) {
        this.reviewMBList = reviewMBList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}
