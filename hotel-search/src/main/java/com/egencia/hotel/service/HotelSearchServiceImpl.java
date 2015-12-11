package com.egencia.hotel.service;

import com.egencia.hotel.builder.HotelSolutionsBuilder;
import com.egencia.hotel.model.HotelSolutions;
import com.egencia.hotel.repository.HotelSolutionRepository;
import com.egencia.hotel.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jkurian on 12/11/15.
 */
@Service
public class HotelSearchServiceImpl implements HotelSearchService {

    @Autowired
    HotelSolutionRepository hotelSolutionRepository;

    @Override
    public HotelSolutions search(String hotelID, String frmDate, String toDate) {

        String uri = "http://terminal2.expedia.com/x/hotels?hotelids=" + hotelID + "&dates=" + frmDate + ","
                                                        + toDate + "&apikey=ZmMw848s21a0yuvSYxU6BrDOBPnWQ3d8";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        JsonNode jsonNode = JSONUtil.parseJSON(result);
        HotelSolutions hotelSolutions = null;
        if (jsonNode != null) {
            hotelSolutions = HotelSolutionsBuilder.build(jsonNode);
        }
        hotelSolutions = save(hotelSolutions);
        return hotelSolutions;
    }

    private HotelSolutions save(HotelSolutions hotelSolutions) {
        HotelSolutions savedHotelSolutions = hotelSolutionRepository.save(hotelSolutions);
        return savedHotelSolutions;
    }

}
