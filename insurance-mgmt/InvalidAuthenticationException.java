package com.gtxc.practice.insurancemgmt;

/*
    Created by gt at 11:31 PM on Tuesday, February 22, 2022.
    Project: practice, Package: com.gtxc.practice.insurancemgmt.
*/

public class InvalidAuthenticationException extends Exception {

    public InvalidAuthenticationException(String errorMessage) {
        super(errorMessage);
    }
}
