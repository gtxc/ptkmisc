package com.gtxc.practice.seasonschedule;

/*
    Created by gt at 3:51 AM on Monday, February 21, 2022.
    Project: practice, Package: com.gtxc.practice.leaguetable.
*/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SeasonSchedule {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<String> teams = new HashSet<>();
        while (scanner.hasNext()) {
            teams.add(scanner.nextLine());
        }

        ScheduleGenerator scheduleGenerator = new ScheduleGenerator(teams);
        scheduleGenerator.printSchedule();
    }
}

/*

Timberwolves
Lakers
Bulls
76ers
Celtics
Warriors
Bucks
Cavaliers
Hawks

 */