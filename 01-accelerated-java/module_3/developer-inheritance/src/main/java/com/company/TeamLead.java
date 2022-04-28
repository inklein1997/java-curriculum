package com.company;

public class TeamLead extends Developer {

    public TeamLead(String name, int hireYear, String preferredProgrammingLanguage) {
        super(name, hireYear, preferredProgrammingLanguage);
        System.out.println("Makin' a teamLead neamed " + name);
    }
    public TeamLead() {
        super();
    }

    public void planSprint() {
        System.out.println(this.name + " says: We commit to deliver 100 points.");
    }
    public void assignWork(Developer dev) {
        System.out.println(this.name + "says : " + dev.getName() + ", start coding.");
    }

    public int estimateStoryPoints() {
        System.out.println(this.name + " says: Nope!  That's only 2 points. Work smarter!");
        return 2;
    }
}
