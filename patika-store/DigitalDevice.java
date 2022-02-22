package com.gtxc.practice.ptkstore;

/*
    Created by gt at 10:59 PM on Monday, February 21, 2022.
    Project: practice, Package: com.gtxc.practice.ptkstore.
*/

import java.lang.reflect.Field;

public abstract class DigitalDevice extends Product {

    private String name;
    private double price;
    private double discountRate;
    private int stockAmount;
    private int internalStorageGB;
    private double displaySizeInch;
    private int ramGB;

    public DigitalDevice() {
        super();
    }

    public DigitalDevice(Brand brandName, String name, double price, double discountRate, int stockAmount, int internalStorageGB, double displaySizeInch, int ramGB) {
        super(brandName);
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.internalStorageGB = internalStorageGB;
        this.displaySizeInch = displaySizeInch;
        this.ramGB = ramGB;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public int getInternalStorageGB() {
        return internalStorageGB;
    }

    public double getDisplaySizeInch() {
        return displaySizeInch;
    }

    public int getRamGB() {
        return ramGB;
    }

    @Override
    public String toString() {
        return super.toString() + "--sep--" +
                name + "--sep--" +
                price + "--sep--" +
                discountRate + "--sep--" +
                stockAmount + "--sep--" +
                internalStorageGB + "--sep--" +
                displaySizeInch + "--sep--" +
                ramGB;
    }

    @Override
    public String getFieldsAsString() {
        Field[] fields = DigitalDevice.class.getDeclaredFields();
        StringBuilder field = new StringBuilder();
        for (Field value : fields) {
            field.append(value.getName()).append("--sep--");
        }
        return super.getFieldsAsString() + field.toString();
    }
}
