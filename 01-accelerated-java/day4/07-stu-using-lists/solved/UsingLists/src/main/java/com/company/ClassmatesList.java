package com.company;

import java.util.ArrayList;
import java.util.List;

public class ClassmatesList {

    private List<Classmate> classmatesList = new ArrayList<>();

    public void add(Classmate classmate) {
        classmatesList.add(classmate);
    }

    public Classmate get(int index) {
        return classmatesList.get(index);
    }

    public List<Classmate> getAll() {
        return classmatesList;
    }

}
