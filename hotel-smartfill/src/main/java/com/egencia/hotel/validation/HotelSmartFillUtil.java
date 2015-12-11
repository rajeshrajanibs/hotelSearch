package com.egencia.hotel.validation;

import com.egencia.hotel.model.Solution;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by djoseph on 12/11/15.
 */
public class HotelSmartFillUtil {

    public static List<Solution> setSolution(String response){


        List<Solution> solutions = new ArrayList<Solution>();

        JSONObject jsonObject = new JSONObject(response.toString());
        JSONArray jsonArray1 = jsonObject.getJSONArray("sr");
        for(int i=0; i < jsonArray1.length(); i++){
            JSONObject jsonObject1 = (JSONObject)jsonArray1.get(i);
            Solution solution = new Solution();
            solution.setId(jsonObject1.getString("id"));
            solution.setLocationName(jsonObject1.getString("f"));
            solutions.add(solution);
        }
        return solutions;
    }
}
