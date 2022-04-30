package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calc;
    @Before
    public void setUp() {
        calc = new Calculator();
    }
    @Test
    public void shouldSumArrays() {

        int[] testArr1 = {1,2,3,4};
        int[] testArr2 = {5};
        int[] testArr3 = {0, 24, -3, 50, 104, -35};

        assertEquals(15, calc.sumArrays(testArr1, testArr2));
        assertEquals(145, calc.sumArrays(testArr2, testArr3));
        assertEquals(150, calc.sumArrays(testArr1, testArr3));
    }

    @Test
    public void shouldArrayify() {
        int[] output1 = {5,6,7};
        int[] output2 = {-2, -1, 0, 1, 2, 3};
        int[] output3 = {104};

        assertArrayEquals(output1, calc.arrayify(3,5));
        assertArrayEquals(output2, calc.arrayify(6,-2));
        assertArrayEquals(output3, calc.arrayify(1,104));

    }

}