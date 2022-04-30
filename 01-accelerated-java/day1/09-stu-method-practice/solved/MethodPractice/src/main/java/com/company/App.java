package com.company;

public class App {

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int subtractOrZero(int a, int b) {
        int diff = a - b;
        if (diff < 0) {
            return 0;
        } else {
            return diff;
        }
    }

    public static int max(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        return max;
    }

    public static int min(int a, int b, int c) {
        int min = a;

        if (b < min) {
            min = b;
        }

        if (c < min) {
            min = c;
        }

        return min;
    }

    public static boolean isLarger(int first, int second) {
        if (first > second) {
            return true;
        } else {
            return false;
        }
    }
}
