package com.gtxc.practice.insurancemgmt;

/*
    Created by gt at 4:40 PM on Tuesday, February 22, 2022.
    Project: practice, Package: com.gtxc.practice.insurancemgmt.
*/

interface Address {

    String getCity();

    void setCity(String city);

    String getCountry();

    void setCountry(String country);

    String getPostalCode();

    void setPostalCode(String postalCode);

    String getStateOrProvince();

    void setStateOrProvince(String stateOrProvince);

    String getStreet();

    void setStreet(String street);

    String getStreetNumber();

    void setStreetNumber(String streetNumber);

    String getType();

    void setType(String type);

}
