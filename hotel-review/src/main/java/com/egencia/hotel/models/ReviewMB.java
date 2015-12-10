package com.egencia.hotel.models;

import org.springframework.data.annotation.Id;

/**
 * Created by anambiath on 12/10/15.
 */
public class ReviewMB {

    @Id
    private String Id;
    private String hotelId;
    private String reviewText;
    private String userName;
    private String reviewTitle;
    private int ratingOverall;
    private String negativeRemarks;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public int getRatingOverall() {
        return ratingOverall;
    }

    public void setRatingOverall(int ratingOverall) {
        this.ratingOverall = ratingOverall;
    }

    public String getNegativeRemarks() {
        return negativeRemarks;
    }

    public void setNegativeRemarks(String negativeRemarks) {
        this.negativeRemarks = negativeRemarks;
    }
}
