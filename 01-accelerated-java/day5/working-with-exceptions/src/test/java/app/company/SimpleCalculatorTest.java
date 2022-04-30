package app.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleCalculatorTest {

    private SimpleCalculator simpleCalculator;

    @Before
    public void setUp() throws Exception {
        simpleCalculator = new SimpleCalculator();
    }

    @Test
    public void shouldPerformSimpleIntegerDivision() {
        assertEquals(3, simpleCalculator.divide(6,2));
        assertEquals(10, simpleCalculator.divide(80,8));
        assertEquals(6, simpleCalculator.divide(37,6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenDividingByZero() {
        simpleCalculator.divide(10,0);
    }
}