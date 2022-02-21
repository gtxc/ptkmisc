package com.gtxc.practice.seasonschedule;

/*
    Created by gt at 12:28 PM on Monday, February 21, 2022.
    Project: practice, Package: com.gtxc.practice.seasonschedule.
*/

import java.util.*;

public class ScheduleGenerator {

    private final Set<String> teams;
    private List<Map<String, String>> schedule;

    public ScheduleGenerator(Set<String> teams) {
        this.teams = teams;
        this.schedule = new ArrayList<>();
        if (getNoOfTeams() % 2 == 1) {
            this.teams.add("Dummy");
        }
        this.setSchedule(this.teams);
    }

    private void setSchedule(Set<String> teams) {
        List<String> shuffledTeams = new ArrayList<>(teams);
        Collections.shuffle(shuffledTeams);

        int noOfTeams = teams.size();
        int totalRounds = (noOfTeams-1) * 2;

        String[] home = shuffledTeams.subList(0,  noOfTeams/2).toArray(new String[0]);
        String[] away = shuffledTeams.subList(noOfTeams/2, noOfTeams).toArray(new String[0]);

        while (totalRounds-- > 0) {
            Map<String, String> round = new HashMap<>();
            for (int i = 0; i < home.length; ++i) {
                if (totalRounds % 2 == 0) {
                    round.put(home[i], away[i]);
                } else {
                    round.put(away[i], home[i]);
                }
            }
            this.schedule.add(round);
            String hometmp = home[home.length-1];
            String awaytmp = away[0];
            System.arraycopy(home, 1, home, 2, home.length - 2);
            System.arraycopy(away, 1, away, 0, away.length - 1);
            home[1] = awaytmp;
            away[away.length-1] = hometmp;
        }
    }

    public void printSchedule() {
        System.out.printf("\n*** %sSCHEDULE ***\n", schedule.isEmpty() ? "NO " : "");
        int roundNumber = 1;
        for (Map<String, String> round : schedule) {
            System.out.println("Round " + roundNumber++);
            round.forEach((home, away) -> {
                System.out.println("\t" + home + " vs " + away);
            });
            System.out.println();
        }
    }

    private int getNoOfTeams() {
        return this.teams.size();
    }
}
