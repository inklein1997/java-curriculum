package com.company;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else {
            return a/b;
        }
    }
}
