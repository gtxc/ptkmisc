package com.gtxc.practice.ptkstore;

/*
    Created by gt at 10:35 PM on Monday, February 21, 2022.
    Project: practice, Package: com.gtxc.practice.ptkstore.
*/

import java.lang.reflect.Field;

public class MobilePhone extends DigitalDevice {

    private int batteryCapacitymAh;
    private String color;

    public MobilePhone() {
        super();
    }

    public MobilePhone(Brand brandName, String name, double price, double discountRate, int stockAmount, int internalStorageGB, double displaySizeInch, int ramGB, int batteryCapacitymAh, String color) {
        super(brandName, name, price, discountRate, stockAmount, internalStorageGB, displaySizeInch, ramGB);
        this.batteryCapacitymAh = batteryCapacitymAh;
        this.color = color;
    }

    public int getBatteryCapacitymAh() {
        return batteryCapacitymAh;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString() + "--sep--" +
                batteryCapacitymAh + "--sep--" +
                color;
    }

    @Override
    public String getFieldsAsString() {
        Field[] fields = MobilePhone.class.getDeclaredFields();
        StringBuilder field = new StringBuilder();
        for (Field value : fields) {
            field.append(value.getName()).append("--sep--");
        }
        return super.getFieldsAsString() + field.toString();
    }
}
