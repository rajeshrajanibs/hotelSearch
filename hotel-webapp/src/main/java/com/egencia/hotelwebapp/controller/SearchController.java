package com.egencia.hotelwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: rrajan
 * Date: 12/10/15
 * Time: 2:17 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class SearchController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}

