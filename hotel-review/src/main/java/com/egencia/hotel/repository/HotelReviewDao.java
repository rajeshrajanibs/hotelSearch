package com.egencia.hotel.repository;

import com.egencia.hotel.models.ReviewMB;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;

/**
 * Created by anambiath on 12/11/15.
 */

public interface HotelReviewDao {

    public List<ReviewMB> getReviews(JSONObject obj, String hotelId)throws JSONException;
}
