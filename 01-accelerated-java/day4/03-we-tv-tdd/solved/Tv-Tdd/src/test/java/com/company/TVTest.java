package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TVTest {
    TV tele;

    @Before
    public void setUp() {
        tele = new TV(15);
    }

    @Test
    public void shouldTurnOn() {
        tele.on();
        assertTrue(tele.isOn());
    }

    @Test
    public void shouldTurnOff() {
        tele.off();
        assertFalse(tele.isOn());
    }

    @Test
    public void shouldChangeChannel() {
        tele.increaseChannel();
        tele.increaseChannel();
        assertEquals(17, tele.getChannel());
    }
}
