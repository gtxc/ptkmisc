package com.gtxc.practice.ptkstore;

/*
    Created by gt at 11:57 PM on Monday, February 21, 2022.
    Project: practice, Package: com.gtxc.practice.ptkstore.
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Warehouse {

    private List<MobilePhone> mobilePhones;
    private List<Notebook> notebooks;

    public Warehouse() {
        mobilePhones = new ArrayList<>();
        notebooks = new ArrayList<>();
    }

    public List<MobilePhone> getMobilePhones() {
        return mobilePhones;
    }

    public void setMobilePhones(List<MobilePhone> mobilePhones) {
        this.mobilePhones = mobilePhones;
    }

    public List<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(List<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    public boolean addMobilePhone(MobilePhone mobilePhone) {
        return this.mobilePhones.add(mobilePhone);

    }

    public boolean addNotebook(Notebook notebook) {
        return this.notebooks.add(notebook);
    }

    public void listBrands() {
        List<String> brands = Stream.of(Brand.values()).map(Brand::name).sorted().collect(Collectors.toList());
        for (String b : brands) {
            System.out.println("\t\t - " + b);
        }
    }

    public void listNotebooksOrderByBrand() {
        notebooks.sort(Comparator.comparing(Notebook::getBrandNameAsString));
        printTable(notebooks);
    }

    public void listNotebooksOrderById() {
        notebooks.sort(Comparator.comparing(Notebook::getId));
        printTable(notebooks);
    }

    public void listMobilePhonesOrderByBrand() {
        mobilePhones.sort(Comparator.comparing(MobilePhone::getBrandNameAsString));
        printTable(mobilePhones);
    }

    public void listMobilePhonesOrderById() {
        mobilePhones.sort(Comparator.comparing(MobilePhone::getId));
        printTable(mobilePhones);
    }

    private int getPrintableItemLength(String s) {
        String[] sarr = s.split("--sep--");
        return sarr.length * 25 + sarr.length + 1;
    }

    private void printDashes(int n) {
        System.out.println(new String(new char[n]).replace("\0", "-"));
    }

    private void printItem(String s) {
        String[] sarr = s.split("--sep--");
        for (String str : sarr) {
            System.out.format("|%-25s", str);
        }
        System.out.println("|");
    }

    private <T> void printTable(List<T> list) {
        if (!list.isEmpty()) {
            int dashLength = getPrintableItemLength(list.get(0).toString());
            printDashes(dashLength);
            if (list.get(0) instanceof Notebook) {
                printItem(new Notebook().getFieldsAsString());
            } else if (list.get(0) instanceof MobilePhone) {
                printItem(new MobilePhone().getFieldsAsString());
            }
            printDashes(dashLength);
            for (T t : list) {
                printItem(t.toString());
            }
            printDashes(dashLength);
            System.out.println();
        } else {
            System.out.println("\u001B[31mThere is no data to show.\u001B[0m\n");
        }
    }

    public boolean removeNotebookById(int id) {
        return notebooks.removeIf(n -> n.getId() == id);
    }

    public boolean removeMobilePhoneById(int id) {
        return mobilePhones.removeIf(n -> n.getId() == id);
    }
}
