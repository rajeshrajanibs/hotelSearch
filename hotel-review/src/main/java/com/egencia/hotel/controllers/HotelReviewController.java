package com.egencia.hotel.controllers;

import com.egencia.hotel.models.ReviewMB;
import com.egencia.hotel.repository.HotelSearchConnectionConfig;
import com.egencia.hotel.services.HotelReviewService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;



@RestController
public class HotelReviewController{

    @Inject
    HotelReviewService hotelReviewService;

    @RequestMapping(value = "/getReviews",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, headers = "content-type=application/x-www-form-urlencoded")
    public ResponseEntity<List<ReviewMB>> getHotelReviewData(@RequestBody String hotelId) throws JSONException {
        String url = "http://terminal2.expedia.com/x/reviews/hotels?hotelId="+hotelId+"&apikey=ZmMw848s21a0yuvSYxU6BrDOBPnWQ3d8";
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
            reviewMBs = getReviews(response.toString(), hotelId);
            saveReviewComments(reviewMBs);
            return new ResponseEntity<List<ReviewMB>>(reviewMBs, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<ReviewMB>>(reviewMBs, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private void saveReviewComments(List<ReviewMB> reviewMBs) throws JSONException {
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(HotelSearchConnectionConfig.class);
        MongoOperations mongoOperations = (MongoOperations) applicationContext.getBean("mongoTemplate");
        mongoOperations.save(reviewMBs);
    }

    private List<ReviewMB> getReviews(String reviewData, String hotelId) throws JSONException {
        JSONObject obj = new JSONObject(reviewData);
        List<ReviewMB> reviewMBs  = null;
        try {
            reviewMBs = hotelReviewService.getReviews(obj, hotelId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return reviewMBs;
    }

    @RequestMapping(value = "/findReviews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReviewMB>> getReviewCommentsByHotelId(@RequestBody String hotelId) throws JSONException {
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(HotelSearchConnectionConfig.class);
        MongoOperations mongoOperations = (MongoOperations) applicationContext.getBean("mongoTemplate");
        List<ReviewMB> reviewMBs = mongoOperations.findAll(ReviewMB.class, hotelId);
        if(reviewMBs.isEmpty()){
            reviewMBs = (List<ReviewMB>) getHotelReviewData(hotelId);
        }
        return new ResponseEntity<List<ReviewMB>>(reviewMBs, HttpStatus.OK);
    }

    @RequestMapping(value = "/clearReviews", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void clearReviews(@RequestBody String hotelId){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HotelSearchConnectionConfig.class);
        MongoOperations mongoOperations = (MongoOperations) applicationContext.getBean("mongoTemplate");
        mongoOperations.dropCollection("reviews");
    }

}