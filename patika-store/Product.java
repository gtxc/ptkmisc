package com.gtxc.practice.ptkstore;

/*
    Created by gt at 9:18 PM on Monday, February 21, 2022.
    Project: practice, Package: com.gtxc.practice.ptkstore.
*/

import java.lang.reflect.Field;

public abstract class Product {

    private static int uuid = 0;

    private final int id;
    private Brand brandName;

    public Product() {
        this.id = ++uuid;
    }

    public Product(Brand brandName) {
        this.id = ++uuid;
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }

    public Brand getBrandName() {
        return brandName;
    }

    public String getBrandNameAsString() {
        return brandName.name();
    }

    public void setBrand(Brand brand) {
        this.brandName = brand;
    }

    @Override
    public String toString() {
        return id + "--sep--" + brandName;
    }

    public String getFieldsAsString() {
        Field[] fields = Product.class.getDeclaredFields();
        StringBuilder field = new StringBuilder();
        for (int i = 1; i < fields.length; ++i) {
            field.append(fields[i].getName()).append("--sep--");
        }
        return field.toString();
    }
}
