package com.egencia.hotel.controller;

import com.egencia.hotel.model.Solution;
import com.egencia.hotel.validation.HotelSmartFillUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
public class HotelSmartFillController{

    @CrossOrigin
    @RequestMapping(value = "/getSolutions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Solution>> smartfillSolutions(@RequestParam("location") String hotelLocation){
       // String url = "http://terminal2.expedia.com/x/suggestions/hotels?query="+hotelLocation+"&apikey=ZmMw848s21a0yuvSYxU6BrDOBPnWQ3d8";
       String url = "http://terminal2.expedia.com/x/suggestions/regions?query="+hotelLocation+"&apikey=ZmMw848s21a0yuvSYxU6BrDOBPnWQ3d8";
        List<Solution> solutions = null;

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("response" + response);

            solutions = HotelSmartFillUtil.setSolution(response.toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }

        if(solutions!=null){
            return new ResponseEntity<List<Solution>>(solutions, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<List<Solution>>(solutions, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}