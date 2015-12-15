package com.egencia.hotel.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by jkurian on 12/11/15.
 */
public class JSONUtil {

    public static JsonNode parseJSON(String jsonString) {
        JsonNode jsonObj = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            jsonObj = mapper.readTree(jsonString);
        }catch(JsonParseException e) {
            System.out.println("Exception in parseJSON "+ e);
        }catch(IOException e) {
            System.out.println("Exception in parseJSON "+ e);
        }
        return jsonObj;
    }
}
