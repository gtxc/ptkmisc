package com.gtxc.practice.insurancemgmt;

/*
    Created by gt at 4:40 PM on Tuesday, February 22, 2022.
    Project: practice, Package: com.gtxc.practice.insurancemgmt.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Account implements Comparable<Account> {

    private User user;
    private List<Insurance> insuranceList;
    private AuthenticationStatus authenticationStatus;

    public Account(User user) {
        this.user = user;
        this.insuranceList = new ArrayList<>();
        this.authenticationStatus = null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(List<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public final void showUserInfo() {
        calculateTotalPrice();
        System.out.print(PrintColor.ANSI_CYAN + "\nAccount Owner Details:" + PrintColor.ANSI_RESET);
        System.out.println(PrintColor.ANSI_BLUE +
                    "\n\tFirst Name    : " + user.getFirstName() +
                    "\n\tLast Name     : " + user.getLastName() +
                    "\n\tEmail         : " + user.getEmail() +
                    "\n\tProfession    : " + user.getProfession() +
                    "\n\tAge           : " + user.getAge() +
                    "\n\tShort Address : " + (user.getAddressList() == null ? "null" : user.getAddressList().get(0).getCity()) +
                    "\n\tLast Login    : " + user.getLastLogin() + PrintColor.ANSI_RESET);
        System.out.print(PrintColor.ANSI_CYAN + "Insurances:" + PrintColor.ANSI_RESET);
        if (insuranceList.isEmpty()) {
            System.out.println(PrintColor.ANSI_WHITE + " No insurance yet." + PrintColor.ANSI_RESET);
        }
        insuranceList.forEach(insurance -> System.out.println(PrintColor.ANSI_PURPLE +
                "\n\tName       : " + insurance.getName() +
                "\n\tPrice      : " + insurance.getPrice() +
                "\n\tStart Date : " + insurance.getStartDate() +
                "\n\tEnd Date   : " + insurance.getEndDate() + PrintColor.ANSI_RESET));
        System.out.println(PrintColor.ANSI_YELLOW + "Authentication Status : " +
                (getAuthenticationStatus() == null ?
                    PrintColor.ANSI_WHITE :
                    getAuthenticationStatus().equals(AuthenticationStatus.SUCCESS) ?
                    PrintColor.ANSI_GREEN :
                    PrintColor.ANSI_RED) + getAuthenticationStatus() + PrintColor.ANSI_RESET);
    }

    public final void login(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            setAuthenticationStatus(AuthenticationStatus.SUCCESS);
        } else {
            throw new InvalidAuthenticationException("InvalidAuthenticationException");
        }
    }

    public final boolean loginStatus() {
        return getAuthenticationStatus() != null && (!getAuthenticationStatus().equals(AuthenticationStatus.FAIL));
    }

    public boolean addAddress(Address address) {
        return AddressManager.addAddress(user, address);
    }

    public boolean removeAddress(Address address) {
        return AddressManager.removeAddress(user, address);
    }

    public abstract void addInsurance(Insurance insurance);

    private void calculateTotalPrice() {
        insuranceList.forEach(Insurance::calculate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(user, account.user) && Objects.equals(insuranceList, account.insuranceList) && authenticationStatus == account.authenticationStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, insuranceList, authenticationStatus);
    }

    @Override
    public int compareTo(Account account) {
        return this.getUser().getEmail().compareTo(account.getUser().getEmail());
    }
}
