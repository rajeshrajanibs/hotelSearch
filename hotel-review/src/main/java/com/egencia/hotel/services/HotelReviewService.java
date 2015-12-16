package com.egencia.hotel.services;

import com.egencia.hotel.models.ReviewMB;
import com.egencia.hotel.models.TotalReviews;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by anambiath on 12/10/15.
 */


public interface HotelReviewService extends Serializable{
    public static final long serialVersionUID = 1L;


    public List<ReviewMB> getReviews(String reviewData) throws JSONException;

    public String getReviewsFromAPI(String hotelId) throws IOException;

    public void saveReviewComments(TotalReviews totalReviewMB) throws Exception;
}
