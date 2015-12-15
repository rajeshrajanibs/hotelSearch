package com.egencia.hotel.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by anambiath on 12/10/15.
 */
@Document(collection="reviews")
public class ReviewMB {

    @Id
    private String Id;
    private String hotelId;
    private String reviewText;
    private String userName;
    private String reviewTitle;
    private int ratingOverall;
    private String negativeRemarks;

    public ReviewMB() {

    }

    public ReviewMB(String hotelId, String reviewText, String userName, String reviewTitle,
                    int ratingOverall, String negativeRemarks) {
        this.hotelId = hotelId;
        this.reviewText = reviewText;
        this.userName = userName;
        this.reviewTitle = reviewTitle;
        this.ratingOverall = ratingOverall;
        this.negativeRemarks = negativeRemarks;
    }

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
