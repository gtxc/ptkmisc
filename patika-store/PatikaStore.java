package com.gtxc.practice.ptkstore;

/*
    Created by gt at 9:14 PM on Monday, February 21, 2022.
    Project: practice, Package: com.gtxc.practice.ptkstore.
*/

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PatikaStore {

    public static Warehouse warehouse = DevBootstrap.initializeWarehouse();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        mainOperations();
        scanner.close();
    }

    public static void printMainMenu() {
        System.out.println( "\t 1 - Notebook Operations\n" +
                            "\t 2 - Mobile Phone Operations\n" +
                            "\t 3 - List Brands\n" +
                            "\t 0 - Quit\n");

    }

    public static void printNotebookMenu() {
        System.out.println( "\t\t 1 - List Notebooks\n" +
                            "\t\t 2 - Add Notebook\n" +
                            "\t\t 3 - Delete Notebook by Id\n" +
                            "\t\t 0 - Back\n");
    }

    public static void printMobilePhoneMenu() {
        System.out.println( "\t\t 1 - List Mobile Phones\n" +
                            "\t\t 2 - Add Mobile Phone\n" +
                            "\t\t 3 - Delete Mobile Phone by Id\n" +
                            "\t\t 0 - Back\n");
    }

    public static void printListChoice() {
        System.out.println( "\t\t\t 1 - Order by Id\n" +
                            "\t\t\t 2 - Order by Brand\n" +
                            "\t\t\t 0 - Back\n");
    }

    public static void mainOperations() {
        System.out.println("\t** PatikaStore Management Panel **");
        printMainMenu();
        int choice = -1;
        while (choice != 0) {
            choice = takeMenuChoice();
            switch (choice) {
                case 1:
                    notebookOperations();
                    break;
                case 2:
                    mobilePhoneOperations();
                    break;
                case 3:
                    brandOperations();
                    break;
                case 0:
                    bye();
                    break;
                case 9:
                    printMainMenu();
                    break;
                default:
                    invalidChoice();
                    printMainMenu();
            }
        }
    }

    public static void notebookOperations() {
        System.out.println("\t\t** Notebook Operations **");
        printNotebookMenu();
        int choice = -1;
        while (choice != 0) {
            choice = takeMenuChoice();
            switch (choice) {
                case 1:
                    printListChoice();
                    listNotebooks();
                    break;
                case 2:
                    addNewNotebook();
                    break;
                case 3:
                    deleteNotebook();
                    break;
                case 9 :
                    printNotebookMenu();
                    break;
                case 0:
                    byeNop();
                    printMainMenu();
                    break;
                default:
                    invalidChoice();
                    printNotebookMenu();
            }
        }
    }

    public static void mobilePhoneOperations() {
        System.out.println("\t\t** Mobile Phone Operations **");
        printMobilePhoneMenu();
        int choice = -1;
        while (choice != 0) {
            choice = takeMenuChoice();
            switch (choice) {
                case 1:
                    printListChoice();
                    listMobilePhones();
                    break;
                case 2:
                    addNewMobilePhone();
                    break;
                case 3:
                    deleteMobilePhone();
                    break;
                case 9 :
                    printMobilePhoneMenu();
                    break;
                case 0:
                    byeMop();
                    printMainMenu();
                    break;
                default:
                    invalidChoice();
                    printMobilePhoneMenu();
            }
        }
    }

    public static void listNotebooks() {
        int choice = -1;
        while (choice != 0) {
            choice = takeMenuChoice();
            switch (choice) {
                case 1:
                    warehouse.listNotebooksOrderById();
                    break;
                case 2:
                    warehouse.listNotebooksOrderByBrand();
                    break;
                case 9:
                    printListChoice();
                    break;
                case 0:
                    exitListing();
                    printNotebookMenu();
                    break;
                default:
                    invalidChoice();
                    printListChoice();
            }
        }
    }

    public static void listMobilePhones() {
        int choice = -1;
        while (choice != 0) {
            choice = takeMenuChoice();
            switch (choice) {
                case 1:
                    warehouse.listMobilePhonesOrderById();
                    break;
                case 2:
                    warehouse.listMobilePhonesOrderByBrand();
                    break;
                case 9:
                    printListChoice();
                    break;
                case 0:
                    exitListing();
                    printMobilePhoneMenu();
                    break;
                default:
                    invalidChoice();
                    printListChoice();
            }
        }
    }

    public static void brandOperations() {
        System.out.println("\t\t** Brands **");
        warehouse.listBrands();
        System.out.println();
    }

    public static void bye() {
        System.out.println("Exiting... Have a nice day.\n");
    }

    public static void byeNop() {
        System.out.println("Exiting... Notebook Operations.\n");
    }

    public static void byeMop() {
        System.out.println("Exiting... Mobile Phone Operations.\n");
    }

    public static void exitListing() {
        System.out.println("Exiting... Listing.\n");
    }

    public static void invalidChoice() {
        System.out.println("\u001B[31mInvalid choice.\u001B[0m\n");
    }

    public static void invalidOption() {
        System.out.println("\u001B[31mEnter a valid option.\u001B[0m\n");
    }

    public static int takeIntChoice() {
        int choice = -1;
        try {
            String s = scanner.nextLine();
            choice = Integer.parseInt(s);
        } catch (Exception ignored) {
            invalidOption();
        }
        return choice;
    }

    public static double takeDoubleChoice() {
        double choice;
        try {
            String s = scanner.nextLine();
            choice = Double.parseDouble(s);
        } catch (Exception ignored) {
            invalidOption();
            return -1;
        }
        return choice;
    }

    public static String takeStringChoice() {
        return scanner.nextLine();
    }

    public static int takeMenuChoice() {
        int choice;
        while (true) {
            System.out.print("Choice (Enter 9 for menu): ");
            try {
                String s = scanner.nextLine();
                choice = Integer.parseInt(s);
                break;
            } catch (Exception ignored) {
                System.out.println("\u001B[31mEnter a valid option.\u001B[0m\n");
            }
        }
        return choice;
    }

    public static void addNewNotebook() {
        System.out.println("\n\t\t\tAdding new Notebook...");
        if (warehouse.addNotebook(new Notebook(
                selectBrand(),
                writeDeviceName(),
                writePrice(),
                writeDiscount(),
                writeStockAmount(),
                writeInternalStorage(),
                writeDisplaySize(),
                writeRam()
        ))) {
            System.out.println("Notebook added successfully.");
        } else {
            System.out.println("Notebook cannot be added, please try again.");
        }
    }

    public static void addNewMobilePhone() {
        System.out.println("\n\t\t\tAdding new Mobile Phone...");
        if (warehouse.addMobilePhone(new MobilePhone(
                selectBrand(),
                writeDeviceName(),
                writePrice(),
                writeDiscount(),
                writeStockAmount(),
                writeInternalStorage(),
                writeDisplaySize(),
                writeRam(),
                writeBatteryCapacity(),
                writeDeviceColor()
        ))) {
            System.out.println("Mobile Phone added successfully.");
        } else {
            System.out.println("Mobile Phone cannot be added, please try again.");
        }
    }

    public static Brand selectBrand() {
        List<String> brands = listBrandsToChoose();
        int choice;
        while (true) {
            System.out.print("\t\t\tChoice ([1-" + brands.size() + "] inclusive): ");
            choice = takeIntChoice();
            if (choice > 9 || choice < 1) {
                invalidChoice();
                listBrandsToChoose();
            } else {
                break;
            }
        }
        return Brand.valueOf(brands.get(choice-1));
    }

    public static String writeDeviceName() {
        System.out.print("\n\t\t\tName of the device: ");
        return takeStringChoice();
    }

    public static double writePrice() {
        double price;
        System.out.println();
        while (true) {
            System.out.print("\t\t\tPrice of the device (>= 0): ");
            price = takeDoubleChoice();
            if (price >= 0) {
                break;
            } else {
                invalidChoice();
            }
        }
        return price;
    }

    public static double writeDiscount() {
        double discount;
        System.out.println();
        while (true) {
            System.out.print("\t\t\tDiscount (%): ");
            discount = takeDoubleChoice();
            if (discount >= 0 && discount < 100) {
                break;
            } else {
                invalidChoice();
            }
        }
        return discount;
    }

    public static int writeStockAmount() {
        int stock;
        System.out.println();
        while (true) {
            System.out.print("\t\t\tStock Amount (>= 0): ");
            stock = takeIntChoice();
            if (stock >= 0) {
                break;
            } else {
                invalidChoice();
            }
        }
        return stock;
    }

    public static int writeInternalStorage() {
        int storage;
        System.out.println();
        while (true) {
            System.out.print("\t\t\tInternal Storage (GB): ");
            storage = takeIntChoice();
            if (storage >= 0) {
                break;
            } else {
                invalidChoice();
            }
        }
        return storage;
    }

    public static double writeDisplaySize() {
        double display;
        System.out.println();
        while (true) {
            System.out.print("\t\t\tDisplay Size (inches): ");
            display = takeDoubleChoice();
            if (display > 0) {
                break;
            } else {
                invalidChoice();
            }
        }
        return display;
    }

    public static int writeRam() {
        int ram;
        System.out.println();
        while (true) {
            System.out.print("\t\t\tRam (GB): ");
            ram = takeIntChoice();
            if (ram >= 0) {
                break;
            } else {
                invalidChoice();
            }
        }
        return ram;
    }

    public static int writeBatteryCapacity() {
        int batteryCap;
        System.out.println();
        while (true) {
            System.out.print("\t\t\tBattery Capacity (mAh): ");
            batteryCap = takeIntChoice();
            if (batteryCap >= 0) {
                break;
            } else {
                invalidChoice();
            }
        }
        return batteryCap;
    }

    public static String writeDeviceColor() {
        System.out.print("\n\t\t\tColor the device: ");
        return takeStringChoice();
    }

    public static List<String> listBrandsToChoose() {
        List<String> brands = Stream.of(Brand.values()).map(Brand::name).sorted().collect(Collectors.toList());
        System.out.println("\t\t\tSelect brand: ");
        for (int i = 1; i <= brands.size(); ++i) {
            System.out.println("\t\t\t" + i + " - " + brands.get(i-1));
        }
        System.out.println();
        return brands;
    }

    public static void deleteNotebook() {
        System.out.println("Deleting Notebook by id...");
        warehouse.listNotebooksOrderById();
        int id;
        System.out.println();
        while (true) {
            System.out.print("\t\tEnter an ID to delete: ");
            id = takeIntChoice();
            if (id >= 0) {
                break;
            } else {
                invalidChoice();
            }
        }
        if (warehouse.removeNotebookById(id)) {
            System.out.println("Notebook with id " + id + " successfully removed.");
        } else {
            System.out.println("No such Notebook, cannot be removed.");
        }
    }

    public static void deleteMobilePhone() {
        System.out.println("Deleting Mobile Phone by id...");
        warehouse.listMobilePhonesOrderById();
        int id;
        System.out.println();
        while (true) {
            System.out.print("\t\tEnter an ID to delete: ");
            id = takeIntChoice();
            if (id >= 0) {
                break;
            } else {
                invalidChoice();
            }
        }
        if (warehouse.removeMobilePhoneById(id)) {
            System.out.println("Mobile Phone with id " + id + " successfully removed.");
        } else {
            System.out.println("No such Mobile Phone, cannot be removed.");
        }
    }
}
