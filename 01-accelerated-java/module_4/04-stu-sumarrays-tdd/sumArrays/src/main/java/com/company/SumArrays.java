package com.company;

public class SumArrays {
    public static int sumArrays(int[] arr1, int[] arr2) {
        int total = 0;
        for (int num : arr1) {
            total += num;
        }
        for (int num : arr2) {
            total += num;
        }

        return total;
    }

    public static int[] arrayify(int a, int b) {
        int[] array = {};
        int addingTo = b;
        if (a < 0) {
            return array;
        }

        array = new int[a];

        for (int i = 0; i<a; i++) {
            array[i] = addingTo++;
        }

        return array;
    }

//    int randomNum = (int) (Math.random()*100) + 1;
//    // 5.99 = 5;
}
