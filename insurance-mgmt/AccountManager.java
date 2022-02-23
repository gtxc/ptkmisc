package com.gtxc.practice.insurancemgmt;

/*
    Created by gt at 11:43 PM on Tuesday, February 22, 2022.
    Project: practice, Package: com.gtxc.practice.insurancemgmt.
*/

import java.util.TreeSet;

public class AccountManager {

    private final TreeSet<Account> accounts;

    public AccountManager() {
        this.accounts = new TreeSet<>();
    }

    public Account login(String email, String password) {
        Account loggedInAccount = null;
        for (Account account : accounts) {
            if (account.getUser().getEmail().equals(email) && account.getUser().getPassword().equals(password)) {
                try {
                    account.login(email, password);
                    loggedInAccount = account;
                } catch (InvalidAuthenticationException e) {
                    e.printStackTrace();
                }
            }
        }
        return loggedInAccount;
    }

    public TreeSet<Account> getAccounts() {
        return accounts;
    }

    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    public boolean removeAccount(Account account) {
        return accounts.remove(account);
    }
}
