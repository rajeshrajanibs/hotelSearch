package com.egencia.hotel.controllers;

import com.egencia.hotel.models.ReviewMB;
import com.egencia.hotel.models.TotalReviews;
import com.egencia.hotel.repository.HotelSearchConnectionConfig;
import com.egencia.hotel.services.HotelReviewService;
import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;


@RestController
public class HotelReviewController{

    @Inject
    HotelReviewService hotelReviewService;


    @CrossOrigin
    @RequestMapping(value = "/getReviews",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TotalReviews> getHotelReviewData(@RequestParam("hotelId") String hotelId) throws JSONException {
        TotalReviews totalReviewMB = getReviewCommentsByHotelId(hotelId);
        try {
            if(totalReviewMB == null){
                System.out.println("Api Call **************************************************************");
                totalReviewMB = new TotalReviews();
                List<ReviewMB> reviewMBList = null;
                String reviewData = hotelReviewService.getReviewsFromAPI(hotelId);
                reviewMBList = hotelReviewService.getReviews(reviewData);
                totalReviewMB.setReviewMBList(reviewMBList);
                totalReviewMB.setHotelId(hotelId);
                hotelReviewService.saveReviewComments(totalReviewMB);
            }
            return new ResponseEntity<TotalReviews>(totalReviewMB, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<TotalReviews>(totalReviewMB, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private TotalReviews getReviewCommentsByHotelId(String hotelId) throws JSONException {
        Query query = new Query(Criteria.where("hotelId").is(hotelId));
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(HotelSearchConnectionConfig.class);
        MongoOperations mongoOperations = (MongoOperations) applicationContext.getBean("mongoTemplate");
        TotalReviews totalReviews = mongoOperations.findOne(query, TotalReviews.class);
        return  totalReviews;
    }

    @RequestMapping(value = "/clearReviews", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void clearReviews(@RequestBody String hotelId){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HotelSearchConnectionConfig.class);
        MongoOperations mongoOperations = (MongoOperations) applicationContext.getBean("mongoTemplate");
        mongoOperations.dropCollection("reviews");
    }

}