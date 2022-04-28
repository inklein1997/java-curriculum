package com.company;

import javafx.scene.shape.Arc;

public class SoftwareDevelopmentLifecycle {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Jennifer", 2022, "JavaScript");
        Developer dev2 = new Developer("Hoa", 2021, "JavaScript");
        Developer teamLead = new TeamLead();
        teamLead.setName("Honorine");
        teamLead.setHireYear(1981);
        teamLead.setPreferredProgrammingLanguage("Java");

        Architect architect = new Architect();
        architect.setName("Dan the man");
        architect.setHireYear(1980);
        architect.setPreferredProgrammingLanguage("Ruby");

        dev1.estimateStoryPoints();
        dev2.checkInCode();

//        teamLead.assignWork(dev1);
        teamLead.estimateStoryPoints();

        architect.evaluateVendor();
        architect.estimateStoryPoints();
        architect.planSprint();

        dev1.submitTimeCard();
        dev2.submitTimeCard();
        teamLead.submitTimeCard();
        architect.submitTimeCard();

        Developer[] devs = new Developer[4];
        devs[0] = dev1;
        devs[1] = dev2;
        devs[2] = teamLead;
        devs[3] = architect;

        for (Developer develope: devs) {
            System.out.println("===========" + develope.getName() + "===========");
            develope.submitTimeCard();
            develope.checkInCode();
        }

        for(Object person: devs) {
            System.out.println(person.toString());
        }
    }
}
