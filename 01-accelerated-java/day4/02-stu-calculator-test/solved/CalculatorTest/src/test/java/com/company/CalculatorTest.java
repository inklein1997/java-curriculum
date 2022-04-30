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
    public void shouldDividePositives() {

        assertEquals(3, calc.divide(6,2));
        assertEquals(2, calc.divide(80, 39));
        assertEquals(1, calc.divide(105, 100));
    }

    @Test
    public void shouldDivideNegatives() {

        assertEquals(3, calc.divide(-6,-2));
        assertEquals(2, calc.divide(-80, -39));
        assertEquals(1, calc.divide(-105, -100));
    }

    @Test
    public void shouldDivideBothPosAndNeg() {
        assertEquals(-3, calc.divide(6,-2));
        assertEquals(-2, calc.divide(-80, 39));
        assertEquals(-1, calc.divide(105, -100));
    }

    @Test
    public void shouldReturnZero() {
        assertEquals(0, calc.divide(0,0));
        assertEquals(0, calc.divide(0, 1));
        assertEquals(0, calc.divide(105, 0));
    }

}