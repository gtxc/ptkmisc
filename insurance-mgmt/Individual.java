package com.gtxc.practice.insurancemgmt;

/*
    Created by gt at 4:41 PM on Tuesday, February 22, 2022.
    Project: practice, Package: com.gtxc.practice.insurancemgmt.
*/

public class Individual extends Account {

    private final double basePrice = 99;

    public Individual(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        insurance.setBasePrice(this.basePrice);
        this.getInsuranceList().add(insurance);
    }

    public double getBasePrice() {
        return basePrice;
    }
}
