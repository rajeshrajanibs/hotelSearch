package com.egencia.hotel.services;

import com.egencia.hotel.models.ReviewMB;
import com.egencia.hotel.models.TotalReviews;
import com.egencia.hotel.repository.HotelReviewDao;
import com.egencia.hotel.repository.HotelSearchConnectionConfig;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anambiath on 12/10/15.
 */

@Service("hotelReviewService")
public class HotelReviewServiceImpl implements HotelReviewService {

    @Inject
    HotelReviewDao hotelReviewDao;

    @Override
    public List<ReviewMB> getReviews(String reviewData) throws JSONException {
        JSONObject obj = new JSONObject(reviewData);
        List<ReviewMB> reviewMBs  = new ArrayList<ReviewMB>();
        try {
            reviewMBs = hotelReviewDao .getReviews(obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return reviewMBs;

    }

    @Override
    public String getReviewsFromAPI(String hotelId) throws IOException {
        String url = "http://terminal2.expedia.com/x/reviews/hotels?hotelId=" + hotelId + "&apikey=ZmMw848s21a0yuvSYxU6BrDOBPnWQ3d8";
        URL obj;
        StringBuffer response = new StringBuffer();
        obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    @Override
    public void saveReviewComments(TotalReviews totalReviewMB) throws Exception{
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(HotelSearchConnectionConfig.class);
        MongoOperations mongoOperations = (MongoOperations) applicationContext.getBean("mongoTemplate");
        mongoOperations.save(totalReviewMB);
    }

}
