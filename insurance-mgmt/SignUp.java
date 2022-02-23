package com.gtxc.practice.insurancemgmt;

/*
    Created by gt at 11:51 PM on Tuesday, February 22, 2022.
    Project: practice, Package: com.gtxc.practice.insurancemgmt.
*/

import java.util.Scanner;

public class SignUp {

    public static String[] signUp() {
        Scanner scanner = new Scanner(System.in);
        String email;
        String password;

        System.out.println(PrintColor.ANSI_BLUE + "\n** Welcome to Insurance Management System" + PrintColor.ANSI_RESET);
        System.out.println(PrintColor.ANSI_GREEN + "Please provide your email and password to login your account." + PrintColor.ANSI_RESET);
        System.out.print(PrintColor.ANSI_CYAN + "\tEmail: " + PrintColor.ANSI_PURPLE);
        email = scanner.next();
        System.out.print(PrintColor.ANSI_CYAN + "\tPassword: " + PrintColor.ANSI_PURPLE);
        password = scanner.next();
        System.out.println(PrintColor.ANSI_RESET);

        return new String[] {email, password};
    }
}
