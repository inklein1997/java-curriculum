package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calc;

    @Before
    public void runBeforeEachIndividualTest() {
        calc = new Calculator();
    }

    @Test
    public void shouldAddTwoPositiveIntegers() {
        assertEquals(12, calc.add(4,8));
        assertEquals(2000, calc.add(1000,1000));
        assertEquals(12, calc.add(4,8));

    }

    @Test
    public void shouldAddTwoNegativeIntegers() {
//        Calculator calc =  new Calculator();
        int actualResult = calc.add(-10, -3);
        int expectResult = -13;
        assertEquals(expectResult, actualResult);
    }

    @Test
    public void shouldAddPositiveAndNegative() {
//        Calculator calc = new Calculator();
        int actualResult = calc.add(100, -3);
        int expectedResult = 97;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldDividePositiveInt() {
        assertEquals(5, calc.divide(25,5));
    }

    @Test
    public void shouldReturnZeroIfIncludesZero() {
        assertEquals(0, calc.divide(0,5));
        assertEquals(0, calc.divide(1000,0));
    }

    @Test
    public void shouldDivideNegativeInt() {
        assertEquals(1, calc.divide(-5,-5));
        assertEquals(20, calc.divide(-100,-5));
    }

    @Test
    public void shouldDivideNegativeAndPositive() {
        assertEquals(-1000, calc.divide(9000,-9));
    }

    @Test
    public void shouldDivideAndReturnWholeNumber() {
        assertEquals(5, calc.divide(16,3));
    }

    @Test
    public void shouldReturnZeroWhenDividingZeroByZero() {
        assertEquals(0, calc.divide(0,0));
    }
}