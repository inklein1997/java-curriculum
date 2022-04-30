package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayFunTest {
    ArrayFun tester;

    int[][] testArr1;
    int[][] testArr2;
    int[][] testArr3;

    int[][] testArr4;

    @Before
    public void setUp() {
        tester = new ArrayFun();

        testArr1 = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };

        testArr2 = new int[][] {
                {6, 4, 10, 12},
                {1, 90, 50, 43}
        };

        testArr3 = new int[][] {
                {1},
                {4},
                {0}
        };

        testArr4 = new int[][] {
                {1,2,3},
                {4,5,-6},
                {7,8,9}
        };

    }

    @Test
    public void shouldAverageArrays(){
        assertArrayEquals(new int[] {2,5,8,11}, tester.averageArrays(testArr1));
        assertArrayEquals(new int[] {8,46}, tester.averageArrays(testArr2));
        assertArrayEquals(new int[] {1,4,0}, tester.averageArrays(testArr3));
    }

    @Test(expected= IllegalArgumentException.class)
    public void shouldThrowWithNegative(){
        tester.averageArrays(testArr4);
    }

}