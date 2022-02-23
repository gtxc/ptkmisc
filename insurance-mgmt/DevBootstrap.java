package com.gtxc.practice.insurancemgmt;

/*
    Created by gt at 11:50 PM on Tuesday, February 22, 2022.
    Project: practice, Package: com.gtxc.practice.insurancemgmt.
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DevBootstrap {

    public static AccountManager initializeAccounts() throws ParseException {
        AccountManager accountManager = new AccountManager();
        Individual alyssa = new Individual(new User(
                "Ayssa",
                "Pace",
                "alyssapace@mail.com",
                "alyssapw",
                "Radio Mechanic",
                46
        ));

        Enterprise brent = new Enterprise(new User(
                "Brent",
                "Moore",
                "brentmoore@mail.com",
                "brentpw",
                "Shoe Machine Operator and Tender",
                52
        ));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        Insurance alyssaCarInsurance = new CarInsurance("carInsurance", sdf.parse("01/01/2022"), sdf.parse("01/02/2022"));
        Insurance alyssaHealthInsurance = new HealthInsurance("healthInsurance", sdf.parse("01/01/2022"), sdf.parse("01/02/2022"));
        Insurance alyssaResidenceInsurance = new ResidenceInsurance("residenceInsurance", sdf.parse("01/01/2022"), sdf.parse("01/02/2022"));
        Insurance alyssaTravelInsurance = new TravelInsurance("travelInsurance", sdf.parse("01/01/2022"), sdf.parse("01/02/2022"));

        Insurance brentCarInsurance = new CarInsurance("carInsurance", sdf.parse("01/01/2022"), sdf.parse("01/02/2022"));
        Insurance brentHealthInsurance = new HealthInsurance("healthInsurance", sdf.parse("01/01/2022"), sdf.parse("01/02/2022"));
        Insurance brentResidenceInsurance = new ResidenceInsurance("residenceInsurance", sdf.parse("01/01/2022"), sdf.parse("01/02/2022"));
        Insurance brentTravelInsurance = new TravelInsurance("travelInsurance", sdf.parse("01/01/2022"), sdf.parse("01/02/2022"));

        alyssa.addInsurance(alyssaCarInsurance);
        alyssa.addInsurance(alyssaHealthInsurance);
        alyssa.addInsurance(alyssaResidenceInsurance);
        alyssa.addInsurance(alyssaTravelInsurance);

        brent.addInsurance(brentCarInsurance);
        brent.addInsurance(brentHealthInsurance);
        brent.addInsurance(brentResidenceInsurance);
        brent.addInsurance(brentTravelInsurance);

        System.out.println(accountManager.addAccount(alyssa));
        System.out.println(accountManager.addAccount(brent));

        return accountManager;
    }
}
