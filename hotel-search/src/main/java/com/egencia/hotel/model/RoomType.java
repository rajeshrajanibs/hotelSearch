package com.egencia.hotel.model;

/**
 * Created by jkurian on 12/10/15.
 */
public class RoomType {

    private String description;
    private Price price;
    private boolean refundable;

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

    public boolean isRefundable() {
        return refundable;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }
}
