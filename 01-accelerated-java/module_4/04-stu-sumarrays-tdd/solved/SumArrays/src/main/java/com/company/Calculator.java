package com.company;

public class Calculator {
    public int sumArrays(int[] arr1, int[] arr2) {
        int sum = 0;

        for(int num : arr1) {
            sum += num;
        }

        for(int num : arr2) {
            sum += num;
        }

        return sum;
    }

    public int[] arrayify(int size, int start) {
        int[] out = new int[size];

        for(int i = 0; i < size; i++) {
            out[i] = start + i;
        }

        return out;
    }
}
