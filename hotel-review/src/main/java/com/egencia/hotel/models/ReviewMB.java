package com.egencia.hotel.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by anambiath on 12/10/15.
 */
public class ReviewMB {

    private String hotelId;
    private String reviewText;
    private String userName;
    private String reviewTitle;
    private int ratingOverall;
    private String negativeRemarks;
    private String submissionDate;

    public ReviewMB() {

    }

    public ReviewMB(String hotelId, String reviewText, String userName, String reviewTitle,
                    int ratingOverall, String negativeRemarks, String submissionDate) {
        this.hotelId = hotelId;
        this.reviewText = reviewText;
        this.userName = userName;
        this.reviewTitle = reviewTitle;
        this.ratingOverall = ratingOverall;
        this.negativeRemarks = negativeRemarks;
        this.submissionDate = submissionDate;
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

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }
}
