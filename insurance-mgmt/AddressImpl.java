package com.gtxc.practice.insurancemgmt;

/*
    Created by gt at 1:17 AM on Wednesday, February 23, 2022.
    Project: practice, Package: com.gtxc.practice.insurancemgmt.
*/

public class AddressImpl implements Address {

    private String city;
    private String country;
    private String postalCode;
    private String stateOrProvince;
    private String street;
    private String streetNumber;
    private String type;

    public AddressImpl() {
    }

    public AddressImpl(String city, String type) {
        this.city = city;
        this.type = type;
    }

    public AddressImpl(String city, String country, String postalCode, String stateOrProvince, String street, String streetNumber, String type) {
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.stateOrProvince = stateOrProvince;
        this.street = street;
        this.streetNumber = streetNumber;
        this.type = type;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getCountry() {
        return this.country;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getPostalCode() {
        return this.postalCode;
    }

    @Override
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String getStateOrProvince() {
        return stateOrProvince;
    }

    @Override
    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    @Override
    public String getStreet() {
        return this.street;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String getStreetNumber() {
        return this.streetNumber;
    }

    @Override
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}
