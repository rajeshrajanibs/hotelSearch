package com.egencia.hotel.repository;

import com.egencia.hotel.models.ReviewMB;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anambiath on 12/11/15.
 */

@Repository("hotelReviewDao")
public class HotelReviewDaoImpl implements HotelReviewDao{


    @Override
    public List<ReviewMB> saveReviews(JSONObject obj, MongoOperations mongoOperations, String hotelId) throws JSONException {
        JSONObject reviewDetails = obj.getJSONObject("reviewDetails");
        JSONObject reviewCollection = reviewDetails.getJSONObject("reviewCollection");
        JSONArray review = reviewCollection.getJSONArray("review");
        List<ReviewMB> reviewMBs = new ArrayList<ReviewMB>();
        for(int i=0;i<review.length();i++){
            ReviewMB reviewMB = new ReviewMB();
            JSONObject jsonObject = review.getJSONObject(i);
            reviewMB.setReviewText(jsonObject.getString("reviewText"));
            reviewMB.setUserName(jsonObject.getString("userNickname"));
            reviewMB.setReviewTitle(jsonObject.getString("title"));
            reviewMB.setNegativeRemarks(jsonObject.getString("negativeRemarks"));
            reviewMB.setRatingOverall(jsonObject.getInt("ratingOverall"));
            reviewMB.setHotelId(hotelId);
            mongoOperations.save(reviewMB);
            reviewMBs.add(reviewMB);
        }
        return reviewMBs;
    }
}
