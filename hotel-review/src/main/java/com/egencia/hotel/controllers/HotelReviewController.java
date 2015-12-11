package com.egencia.hotel.controllers;

import com.egencia.hotel.models.ReviewMB;
import com.egencia.hotel.repository.HotelReviewConnectionConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelReviewController{

    @RequestMapping(value = "/getReview",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReviewMB>> getHotelReviewData() throws JSONException {
        String url = "http://terminal2.expedia.com/x/reviews/hotels?hotelId=234&apikey=ZmMw848s21a0yuvSYxU6BrDOBPnWQ3d8";
        URL obj;
        StringBuffer response = new StringBuffer();
        List<ReviewMB> reviewMBs = null;
        try {
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
            String hotelId=null;
            reviewMBs = getReviewComments(response.toString(), hotelId);
            return new ResponseEntity<List<ReviewMB>>(reviewMBs, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<ReviewMB>>(reviewMBs, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    private List<ReviewMB> getReviewComments(String reviewData, String hotelId) throws JSONException {
        JSONObject obj = new JSONObject(reviewData);
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(HotelReviewConnectionConfig.class);
        MongoOperations mongoOperations = (MongoOperations) applicationContext.getBean("mongoTemplate");
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

    private List<ReviewMB> getReviewCommentsByHotelId(String hotelId){
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(HotelReviewConnectionConfig.class);
        MongoOperations mongoOperations = (MongoOperations) applicationContext.getBean("mongoTemplate");
        List<ReviewMB> reviewMBs = mongoOperations.findAll(ReviewMB.class, hotelId);
        return reviewMBs;
    }
}