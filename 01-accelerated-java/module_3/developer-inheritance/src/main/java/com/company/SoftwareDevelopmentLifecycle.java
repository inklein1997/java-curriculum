package com.company;

import javafx.scene.shape.Arc;

public class SoftwareDevelopmentLifecycle {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Jennifer", 2022, "JavaScript");
        Developer dev2 = new Developer("Hoa", 2021, "JavaScript");
        TeamLead teamLead = new TeamLead();
        teamLead.setName("Honorine");
        teamLead.setHireYear(1981);
        teamLead.setPreferredProgrammingLanguage("Java");

        Architect architect = new Architect();
        architect.setName("Dan the man");
        architect.setHireYear(1980);
        architect.setPreferredProgrammingLanguage("Ruby");

        dev1.estimateStoryPoints();
        dev2.checkInCode();

        teamLead.assignWork(dev1);
        teamLead.estimateStoryPoints();

        architect.evaluateVendor();
        architect.estimateStoryPoints();
        architect.planSprint();

    }
}
