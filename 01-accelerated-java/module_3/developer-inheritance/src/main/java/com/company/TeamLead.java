package com.company;

public class TeamLead extends Developer {
    public void planSprint() {
        System.out.println("We commit to deliver 100 points.");
    }
    public void assignWork(Developer dev) {
        System.out.println(dev.getName() + ", start coding.");
    }
}
