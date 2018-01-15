package com.jjhellberg;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogicTest {
    Logic logic = new Logic();


    @Test
    public void testGetDistance2() {
        assertEquals(1, logic.distanceTo1(2));
    }

    @Test
    public void testGetDistance3() {
        assertEquals(2, logic.distanceTo1(3));
    }

    @Test
    public void testGetDistance12() {
        assertEquals(3, logic.distanceTo1(12));
    }

    @Test
    public void testGetDistance23() {
        assertEquals(2, logic.distanceTo1(23));
    }

    @Test
    public void testGetDistance1024() {
        assertEquals(31, logic.distanceTo1(1024));
    }

    // Part 2
    @Test
    public void testGreaterThan2() {
        assertEquals(4, logic.firstBigger(2));
    }

    @Test
    public void testGreaterThan5() {
        assertEquals(10, logic.firstBigger(5));
    }

    @Test
    public void testGreaterThan747() {
        assertEquals(806, logic.firstBigger(747));
    }
}