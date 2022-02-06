package com.gtxc.util;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        GList<Integer> integerGList = new GList<>();
        System.out.println(integerGList);
        System.out.println(integerGList.size());
        integerGList.add(3);
        integerGList.add(2);
        integerGList.add(1);
        integerGList.add(15);
        integerGList.add(3);
        integerGList.add(2);
        integerGList.add(1);
        integerGList.add(15);
        integerGList.add(3);
        integerGList.add(2);
        integerGList.add(1);
        integerGList.add(15);
        integerGList.add(3);
        integerGList.add(2);
        integerGList.add(1);
        integerGList.add(15);
        integerGList.add(3);
        integerGList.add(2);
        integerGList.add(1);
        integerGList.add(15);
        integerGList.add(3);
        integerGList.add(2);
        integerGList.add(1);
        integerGList.add(15);

        Object[] a = integerGList.toArray();
        System.out.println(Arrays.toString(a));

        System.out.println(integerGList);
        System.out.println(integerGList.size());
        System.out.println(integerGList.getCapacity());
        System.out.println(integerGList.remove(3));
        System.out.println(integerGList.get(3));
        System.out.println(integerGList.set(330, 16));

        GList<Integer> subList = integerGList.sublist(123, 12324);
        System.out.println(subList);
        System.out.println("size: " + subList.size());
        System.out.println("cap: " + subList.getCapacity());

        integerGList.clear();
        System.out.println("size: " + integerGList.size());
        System.out.println(integerGList);
        System.out.println("cap: " + integerGList.getCapacity());


        GList<String> stringGList = new GList<>();
        System.out.println(stringGList);
        System.out.println("size: " + stringGList.size());
        stringGList.add("GT");
        stringGList.add("Orc");
        stringGList.add("Elf");
        stringGList.add("Orc");
        System.out.println("index: " + stringGList.indexOf("Orc"));
        System.out.println("index: " + stringGList.lastIndexOf("Orc"));
        System.out.println("isEmpty: " + stringGList.isEmpty());
        System.out.println("isEmpty: " + integerGList.isEmpty());
        stringGList.clear();
        System.out.println(stringGList);
        System.out.println("size: " + stringGList.size());
        System.out.println("cap: " + stringGList.getCapacity());
        System.out.println("contains: " + stringGList.contains("GT"));
    }
}
