package com.gtxc.practice.insurancemgmt;

/*
    Created by gt at 4:49 PM on Tuesday, February 22, 2022.
    Project: practice, Package: com.gtxc.practice.insurancemgmt.
*/

import java.util.Date;

public class HealthInsurance extends Insurance {

    private final double fee = 100;

    public HealthInsurance(String name, Date startDate, Date endDate) {
        super(name, startDate, endDate);
    }

    @Override
    public void calculate() {
        int noOfDays = getInsuranceDays();
        setPrice(getBasePrice() + fee * noOfDays);
    }

    public double getFee() {
        return this.fee;
    }
}
