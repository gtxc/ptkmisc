package com.gtxc.practice.insurancemgmt;

/*
    Created by gt at 4:47 PM on Tuesday, February 22, 2022.
    Project: practice, Package: com.gtxc.practice.insurancemgmt.
*/

import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class Insurance {

    private String name;
    private double price;
    private Date startDate;
    private Date endDate;
    private double basePrice;

    public Insurance(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public abstract void calculate();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getInsuranceDays() {
        int noOfDays = 0;
        if (getStartDate().getTime() <= getEndDate().getTime()) {
            long noOfDaysBetweenInMillies = Math.abs(getEndDate().getTime() - getStartDate().getTime());
            noOfDays = (int) TimeUnit.DAYS.convert(noOfDaysBetweenInMillies, TimeUnit.MILLISECONDS);
        }
        return noOfDays;
    }
}
