package com.egencia.hotel.controller;


import com.egencia.hotel.model.HotelSolutions;
import com.egencia.hotel.service.HotelSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jkurian on 12/10/15.
 */
@Controller
public class HotelSearchController {

    @Autowired
    HotelSearchService hotelSearchService;

    @RequestMapping(value = "/searchHotels", method = RequestMethod.GET)
    public HotelSolutions searchHotels(@RequestParam("hotelIds") String hotelIds,
                                             @RequestParam("fromDate") String fromDate,
                                             @RequestParam("toDate") String toDate) {

        HotelSolutions hotelSolutions = hotelSearchService.search(hotelIds,fromDate,toDate);
        return hotelSolutions;
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
