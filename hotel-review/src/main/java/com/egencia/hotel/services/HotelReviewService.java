package com.egencia.hotel.services;

import com.egencia.hotel.models.ReviewMB;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.mongodb.core.MongoOperations;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anambiath on 12/10/15.
 */


public interface HotelReviewService extends Serializable{
    public static final long serialVersionUID = 1L;


    public List<ReviewMB> getReviews(JSONObject obj, MongoOperations mongoOperations, String hotelId) throws JSONException;
}
