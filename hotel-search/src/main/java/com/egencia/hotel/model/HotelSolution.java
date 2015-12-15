package com.egencia.hotel.model;


import java.util.List;

/**
 * Created by jkurian on 12/10/15.
 */
public class HotelSolution {

    private int hotelID;
    private String name;
    private Location location;
    private String description;
    private Price price;
    private String detailsUrl;
    private String starRating;
    private String thumbnailUrl;
    private Amenities amenities;
    private List<RoomType> roomTypes;


    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getDetailsUrl() {
        return detailsUrl;
    }

    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Amenities getAmenities() {
        return amenities;
    }

    public void setAmenities(Amenities amenities) {
        this.amenities = amenities;
    }

    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }

}
