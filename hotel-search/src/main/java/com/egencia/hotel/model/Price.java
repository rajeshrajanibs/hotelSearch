package com.egencia.hotel.model;

/**
 * Created by jkurian on 12/10/15.
 */
public class Price {

    private Money baseRate;
    private Money taxAndFees;
    private Money totalRate;

    public Money getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(Money baseRate) {
        this.baseRate = baseRate;
    }

    public Money getTaxAndFees() {
        return taxAndFees;
    }

    public void setTaxAndFees(Money taxAndFees) {
        this.taxAndFees = taxAndFees;
    }

    public Money getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(Money totalRate) {
        this.totalRate = totalRate;
    }
}
