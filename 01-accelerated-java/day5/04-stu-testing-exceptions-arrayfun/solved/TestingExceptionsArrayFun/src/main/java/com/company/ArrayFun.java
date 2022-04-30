package com.company;

public class ArrayFun {
    public int[] averageArrays(int[][] arr) {
        int[] averages = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            int[] inner = arr[i];
            int avg = 0;
            for (int num : inner) {
                if (num < 0) {
                    throw new IllegalArgumentException("Numbers cannot be negative");
                }

                avg += num;
            }
            avg /= inner.length;
            averages[i] = avg;
        }

        return averages;
    }
}
