package com.gtxc.practice.insurancemgmt;

/*
    Created by gt at 4:54 PM on Tuesday, February 22, 2022.
    Project: practice, Package: com.gtxc.practice.insurancemgmt.
*/

public class AddressManager {

    public static boolean addAddress(User user, Address address) {
        for (Address add : user.getAddressList()) {
            if (add.getType().equals(address.getType())) {
                System.out.println(PrintColor.ANSI_RED + "Given address type is already written in address book." + PrintColor.ANSI_RESET);
                return false;
            }
        }
        user.getAddressList().add(address);
        return true;
    }

    public static boolean removeAddress(User user, Address address) {
        int addIndex = -1;
        for (int i = 0; i < user.getAddressList().size(); ++i) {
            if (user.getAddressList().get(i).getType().equals(address.getType())) {
                addIndex = i;
                break;
            }
        }
        if (addIndex == -1) {
            return false;
        }
        user.getAddressList().remove(addIndex);
        return true;
    }
}
