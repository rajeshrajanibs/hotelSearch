package com.egencia.hotel.mapper;

import com.egencia.hotel.model.*;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jkurian on 12/11/15.
 */
public class HotelSolutionsMapper {

    private JsonNode jsonSolution;
    HotelSolutions hotelSolutions;
    private String regionId;

    public HotelSolutionsMapper(String regionId) {
        this.regionId = regionId;
    }

    public HotelSolutions createHotelSolutions(JsonNode jsonSolution) {
        this.jsonSolution = jsonSolution;
        hotelSolutions = new HotelSolutions();
        hotelSolutions.setHotelCount(jsonSolution.get("HotelCount").asInt());
        hotelSolutions.setRegionId(regionId);
        createStay();
        createSolutions();
        return hotelSolutions;
    }

    private void createStay() {
        JsonNode jStay = jsonSolution.get("StayDates");
        Stay stay = new Stay();
        stay.setCheckInDate(jStay.get("CheckInDate").asText());
        stay.setCheckOutDate(jStay.get("CheckOutDate").asText());
        hotelSolutions.setStay(stay);
    }

    private void createSolutions() {
        JsonNode hotelInfoList = jsonSolution.get("HotelInfoList");
        List<HotelSolution> hotelSolutionList = new ArrayList<HotelSolution>();
        JsonNode hotelInfo = hotelInfoList.get("HotelInfo");
        for (int i = 0; i < 20; i++) {
            HotelSolution hotelSolution = new HotelSolution();
            JsonNode hotel = hotelInfo.get(i);
            try {
                hotelSolution.setHotelID(hotel.get("HotelID").asInt());
                hotelSolution.setName(hotel.get("Name").asText());
                hotelSolution.setDescription(hotel.get("Description").asText());
                if (hotel.get("DetailsUrl") != null) {
                    hotelSolution.setDetailsUrl(hotel.get("DetailsUrl").asText());
                }
                hotelSolution.setStarRating(hotel.get("StarRating").asText());
                hotelSolution.setThumbnailUrl(hotel.get("ThumbnailUrl").asText());

                createLocation(hotel, hotelSolution);
                createPrice(hotel, hotelSolution);
                createRoomTypes(hotel, hotelSolution);
                createAmenities(hotel, hotelSolution);
                hotelSolutionList.add(hotelSolution);
            }catch (Exception e){
                System.out.println("Skipping hotel " + hotelSolution.getHotelID());
            }

        }
        hotelSolutions.setHotelsolutions(hotelSolutionList);
    }

    private void createLocation(JsonNode hotelInfo, HotelSolution hotelSolution) {
        JsonNode jlocation = hotelInfo.get("Location");
        Location location = new Location();

        location.setCity(jlocation.get("City").asText());
        location.setCountry(jlocation.get("Country").asText());
        location.setStreetAddress(jlocation.get("StreetAddress").asText());

        JsonNode jgeoLocation = jlocation.get("GeoLocation");
        GeoLocation geoLocation = new GeoLocation();
        geoLocation.setLatitude(jgeoLocation.get("Latitude").asText());
        geoLocation.setLongitude(jgeoLocation.get("Longitude").asText());
        location.setGeoLocation(geoLocation);

        hotelSolution.setLocation(location);
    }

    private void createPrice(JsonNode hotelInfo, HotelSolution hotelSolution) {


        JsonNode jPrice = hotelInfo.get("Price");
        if(jPrice != null) {
            JsonNode jBaserate = jPrice.get("BaseRate");
            JsonNode jTaxrate = jPrice.get("TaxRcAndFees");
            JsonNode jTotal = jPrice.get("TotalRate");


            Price price = new Price();
            Money baseMoney = new Money();
            baseMoney.setValue(jBaserate.get("Value").asText());
            baseMoney.setCurrency(jBaserate.get("Currency").asText());
            price.setBaseRate(baseMoney);

            Money taxMoney = new Money();
            taxMoney.setValue(jTaxrate.get("Value").asText());
            taxMoney.setCurrency(jTaxrate.get("Currency").asText());
            price.setTaxAndFees(taxMoney);

            Money totalMoney = new Money();
            taxMoney.setValue(jTotal.get("Value").asText());
            taxMoney.setCurrency(jTotal.get("Currency").asText());
            price.setTotalRate(totalMoney);

            hotelSolution.setPrice(price);
        }
    }

    private void createPriceInRoomTypes(JsonNode jRoomType, RoomType roomType) {


        JsonNode jPrice = jRoomType.get("Price");
        JsonNode jBaserate = jPrice.get("BaseRate");
        JsonNode jTaxrate = jPrice.get("TaxRcAndFees");
        JsonNode jTotal = jPrice.get("TotalRate");


        Price price = new Price();
        Money baseMoney = new Money();
        baseMoney.setValue(jBaserate.get("Value").asText());
        baseMoney.setCurrency(jBaserate.get("Currency").asText());
        price.setBaseRate(baseMoney);

        Money taxMoney = new Money();
        taxMoney.setValue(jTaxrate.get("Value").asText());
        taxMoney.setCurrency(jTaxrate.get("Currency").asText());
        price.setTaxAndFees(taxMoney);

        Money totalMoney = new Money();
        totalMoney.setValue(jTotal.get("Value").asText());
        totalMoney.setCurrency(jTotal.get("Currency").asText());
        price.setTotalRate(totalMoney);

        roomType.setPrice(price);
    }

    private void createRoomTypes(JsonNode hotelInfo, HotelSolution hotelSolution) {

        List<RoomType> roomtypes = new ArrayList<RoomType>();
        JsonNode jRoomTypes = hotelInfo.get("RoomTypeList");
        if(jRoomTypes != null) {
            for (int i = 0; i < jRoomTypes.size(); i++) {
                JsonNode jRoomType;
                RoomType roomType = new RoomType();
                if (jRoomTypes.isArray()) {
                    jRoomType = jRoomTypes.get(i);
                } else {
                    jRoomType = jRoomTypes.get("RoomType");
                }

                roomType.setDescription(jRoomType.get("Description").asText());
                roomType.setRefundable(jRoomType.get("Refundable").asBoolean());
                createPriceInRoomTypes(jRoomType, roomType);
                roomtypes.add(roomType);
            }
            hotelSolution.setRoomTypes(roomtypes);
        }
    }


    private void createAmenities(JsonNode hotelInfo, HotelSolution hotelSolution) {

        List<String> amenity = new ArrayList<String>();
        Amenities amenities = new Amenities();
        JsonNode jAmenities = hotelInfo.get("AmenityList");
        if(jAmenities != null) {
            JsonNode jAmenity = jAmenities.get("Amenity");

            for (int i = 0; i < jAmenity.size(); i++) {
                amenity.add(jAmenity.get(i).asText());
            }
            amenities.setAmenities(amenity);
            hotelSolution.setAmenities(amenities);
        }
    }
}
