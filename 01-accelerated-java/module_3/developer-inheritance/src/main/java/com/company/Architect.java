package com.company;

public class Architect extends TeamLead{
    public void createTechRoadmap() {
        System.out.println(getName() + " created the tech roadmap.");
    }
    public void evaluateVendor() {
        System.out.println(getName() + " evaluated the vendor.");
    }
}
