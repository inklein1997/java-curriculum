package com.company;

public class App {

    public static void main(String[] args) {
        StudentClass student1 = new StudentClass();
        student1.setName("Michael");
        student1.setGpa(4.00);

        StudentClass student2 = new StudentClass();
        student2.setName("Patrick");
        student2.setGpa(1.00);

        student1.greet();
        student2.greet();

    }


}
