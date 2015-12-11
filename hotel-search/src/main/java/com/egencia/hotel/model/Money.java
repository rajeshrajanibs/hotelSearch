package com.egencia.hotel.model;

/**
 * Created by jkurian on 12/10/15.
 */
public class Money {

    private String value;
    private String currency;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
