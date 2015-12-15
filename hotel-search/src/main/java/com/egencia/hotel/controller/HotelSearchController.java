package com.egencia.hotel.controller;



import com.egencia.hotel.model.HotelSolution;
import com.egencia.hotel.model.HotelSolutions;
import com.egencia.hotel.model.Search;
import com.egencia.hotel.service.HotelSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jkurian on 12/10/15.
 */


@RestController
public class HotelSearchController {

    @Autowired
    HotelSearchService hotelSearchService;

    @CrossOrigin(origins="http://192.168.71.98:8121", methods = RequestMethod.GET)
    @RequestMapping(value = "/searchHotels", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelSolutions> searchHotels(@RequestParam("regionIds") String regionIds, @RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
        System.out.println("******************************"+fromDate);
        HotelSolutions hotelSolutions = hotelSearchService.search(regionIds, fromDate, toDate);
        if(hotelSolutions != null) {
            return new ResponseEntity<HotelSolutions>(hotelSolutions, HttpStatus.OK);
        } else {
            return new ResponseEntity<HotelSolutions>(hotelSolutions, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


  /*  @RequestMapping(value = "/searchHotels", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    }*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView newSolution() {
        System.out.println("Hiii");
        return new ModelAndView("index");
    }

}
