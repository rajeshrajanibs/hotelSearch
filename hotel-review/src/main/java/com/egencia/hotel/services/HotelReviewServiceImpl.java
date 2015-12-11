package com.egencia.hotel.services;

import com.egencia.hotel.models.ReviewMB;
import com.egencia.hotel.repository.HotelReviewDao;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by anambiath on 12/10/15.
 */

@Service("hotelReviewService")
public class HotelReviewServiceImpl implements HotelReviewService {

    @Inject
    HotelReviewDao hotelReviewDao;

    @Override
    public List<ReviewMB> getReviews(JSONObject obj, MongoOperations mongoOperations, String hotelId) throws JSONException {
              return hotelReviewDao.saveReviews(obj, mongoOperations, hotelId);
    }
}
