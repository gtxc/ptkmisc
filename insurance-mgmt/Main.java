package com.gtxc.practice.insurancemgmt;

/*
    Created by gt at 11:52 PM on Tuesday, February 22, 2022.
    Project: practice, Package: com.gtxc.practice.insurancemgmt.
*/

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

        AccountManager accountManager = DevBootstrap.initializeAccounts();
        accountManager.getAccounts().forEach(Account::showUserInfo);

        String[] loginInfo = SignIn.signIn();

        Account loggedIn = accountManager.login(loginInfo[0], loginInfo[1]);
        if (loggedIn != null) {
            loggedIn.showUserInfo();
        }
    }
}