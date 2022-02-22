package com.gtxc.practice.ptkstore;

/*
    Created by gt at 12:15 AM on Tuesday, February 22, 2022.
    Project: practice, Package: com.gtxc.practice.ptkstore.
*/

public class DevBootstrap {

    public static Warehouse initializeWarehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.addNotebook(new Notebook(Brand.Huawei, "HUAWEI MateBook 14", 7000, 12, 100, 512, 14, 16));
        warehouse.addNotebook(new Notebook(Brand.Lenovo, "LENOVO V14 IGL", 3699, 20, 200, 1024, 14, 8));
        warehouse.addNotebook(new Notebook(Brand.Asus, "ASUS Tuf Gaming", 8199, 5, 300, 2048, 15.6, 32));

        warehouse.addMobilePhone(new MobilePhone(Brand.Samsung, "SAMSUNG GALAXY A51", 3199, 7, 125, 128, 6.5, 6, 4000,"Black"));
        warehouse.addMobilePhone(new MobilePhone(Brand.Apple, "iPhone 11 64 GB", 7379, 3, 50, 64, 6.1, 6, 3046,"Blue"));
        warehouse.addMobilePhone(new MobilePhone(Brand.Xiaomi, "Redmi Note 10 Pro 8GB", 4012, 25, 250, 128, 6.5, 12, 4000,"White"));

        return warehouse;
    }
}
