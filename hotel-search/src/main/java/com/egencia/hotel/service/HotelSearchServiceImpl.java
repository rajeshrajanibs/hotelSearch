package com.egencia.hotel.service;


import com.egencia.hotel.mapper.HotelSolutionsMapper;
import com.egencia.hotel.model.HotelSolutions;
import com.egencia.hotel.repository.HotelSearchConnectionConfig;
import com.egencia.hotel.repository.HotelSearchDao;
import com.egencia.hotel.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jkurian on 12/11/15.
 */
@Service
public class HotelSearchServiceImpl implements HotelSearchService {

    @Autowired
    HotelSearchDao hotelSearchDao;

    @Override

    public HotelSolutions search(String regionIds, String frmDate, String toDate) {

        String uri = "http://terminal2.expedia.com/x/hotels?regionids="+regionIds+"&dates=" + frmDate + ","
                                                        + toDate + "&apikey=ZmMw848s21a0yuvSYxU6BrDOBPnWQ3d8";

//        String uri = "http://terminal2.expedia.com/x/hotels?regionids="+regionIds+"&dates=" + frmDate + ","
//                                                        + toDate + "&apikey=ZmMw848s21a0yuvSYxU6BrDOBPnWQ3d8";
        HotelSolutions hotelSolutions = null;
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HotelSearchConnectionConfig.class);
        MongoOperations mongoOperations = (MongoOperations) applicationContext.getBean("mongoTemplate");
        hotelSolutions = hotelSearchDao.findHotelSolutions(mongoOperations,regionIds,frmDate, toDate);
        if(hotelSolutions != null) {
            return hotelSolutions;
        }else {
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class);
            JsonNode jsonNode = JSONUtil.parseJSON(result);
            System.out.println(result);
            if (jsonNode != null) {
                HotelSolutionsMapper hotelSolutionsMapper = new HotelSolutionsMapper(regionIds);
                hotelSolutions = hotelSolutionsMapper.createHotelSolutions(jsonNode);
            }

            hotelSolutions = save(hotelSolutions, mongoOperations);
            return hotelSolutions;
        }
    }

    private HotelSolutions save(HotelSolutions hotelSolutions,MongoOperations mongoOperations) {
        HotelSolutions savedHotelSolutions = hotelSearchDao.saveHotelSolutions(mongoOperations,hotelSolutions);
        return savedHotelSolutions;
    }

}
