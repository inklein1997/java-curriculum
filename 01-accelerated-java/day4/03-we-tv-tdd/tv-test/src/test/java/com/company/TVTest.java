package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TVTest {
    private TV television;

    @Before
    public void setUp() {
        television = new TV(9);
    }

    @Test
    public void shouldTurnOn() {
        television.turnOn();
        boolean actualValue = television.isOn();
        boolean expectedValue = true;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void shouldBeOffAfterTurnedOnAndThenOff() {
        television.turnOn();
        television.turnOff();

        boolean actualValue = television.isOn();
        boolean expectedValue = false;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void shouldTurnOnAtASpecificChannel() {
        int actualValue = television.getChannel();
        int expectedValue = 9;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void shouldIncreaseChannel() {
        television.increaseChannel();
        assertEquals(10, television.getChannel());
        television.increaseChannel();
        assertEquals(11, television.getChannel());
        television.increaseChannel();

        int actualValue = television.getChannel();
        int expectedValue = 12;

        assertEquals(expectedValue, actualValue);
    }
}