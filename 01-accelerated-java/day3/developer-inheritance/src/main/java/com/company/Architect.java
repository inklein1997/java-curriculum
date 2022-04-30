package com.company;

public class Architect extends TeamLead{
    public Architect() {

    }

    public void createTechRoadmap() {
        System.out.println(this.name + " says: " + getName() + " created the tech roadmap.");
    }
    public void evaluateVendor() {
        System.out.println(this.name + " says: " + getName() + " evaluated the vendor.");
    }
}
