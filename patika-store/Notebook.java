package com.gtxc.practice.ptkstore;

/*
    Created by gt at 10:44 PM on Monday, February 21, 2022.
    Project: practice, Package: com.gtxc.practice.ptkstore.
*/

import java.lang.reflect.Field;

public class Notebook extends DigitalDevice {

    public Notebook() {
        super();
    }

    public Notebook(Brand brandName, String name, double price, double discountRate, int stockAmount, int internalStorageGB, double displaySizeInch, int ramGB) {
        super(brandName, name, price, discountRate, stockAmount, internalStorageGB, displaySizeInch, ramGB);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getFieldsAsString() {
        Field[] fields = Notebook.class.getDeclaredFields();
        StringBuilder field = new StringBuilder();
        for (Field value : fields) {
            field.append(value.getName()).append("--sep--");
        }
        return super.getFieldsAsString() + field.toString();
    }
}
