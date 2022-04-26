package com.company;

import java.util.List;
import java.util.List;

public class App {


	// subtract
    public static int subtract(int a, int b) {
        return a-b;
    }


	// subtractOrZero
    public static int subtractOrZero(int a, int b) {
        if (b > a) {
            return 0;
        } else {
            return a-b;
        }
    }

	// max
    public static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }


	// min
    public static int min(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }


	// isLarger
    public static boolean isLarger(int a, int b) {
        if (a > b) {
            return true;
        } else {
            return false;
        }
    }
}
