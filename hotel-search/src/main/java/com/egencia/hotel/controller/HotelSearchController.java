package com.egencia.hotel.controller;



import com.egencia.hotel.model.HotelSolution;
import com.egencia.hotel.model.HotelSolutions;
import com.egencia.hotel.service.HotelSearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

/**
 * Created by jkurian on 12/10/15.
 */


@RestController
public class HotelSearchController {

    @Inject
    HotelSearchService hotelSearchService;

    @CrossOrigin
    @RequestMapping(value = "/searchHotels", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelSolutions> searchHotels(@RequestParam("regionIds") String regionIds, @RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
        HotelSolutions hotelSolutions = hotelSearchService.search(regionIds, fromDate, toDate);
        if(hotelSolutions != null) {
            return new ResponseEntity<HotelSolutions>(hotelSolutions, HttpStatus.OK);
        } else {
            return new ResponseEntity<HotelSolutions>(hotelSolutions, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/getHotel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelSolution> getHotel(@RequestParam("hotelId") String hotelId,
                                                   @RequestParam("regionIds") String regionIds,
                                                   @RequestParam("fromDate") String fromDate,
                                                   @RequestParam("toDate") String toDate) {
        HotelSolution hotelSolution = hotelSearchService.searchByHotelId(regionIds, hotelId, fromDate, toDate);
        if(hotelSolution != null) {
            return new ResponseEntity<HotelSolution>(hotelSolution, HttpStatus.OK);
        } else {
            return new ResponseEntity<HotelSolution>(hotelSolution, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



  /*  @RequestMapping(value = "/searchHotels", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    }*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView newSolution() {
        return new ModelAndView("index");
    }

}
