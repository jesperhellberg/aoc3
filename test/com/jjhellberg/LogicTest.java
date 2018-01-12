package com.jjhellberg;

import org.apache.commons.collections4.BidiMap;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LogicTest {
    Logic logic = new Logic();

    @Test
    public void testMatrix6() {
        Coord result = logic.getMatrix(6).get(6);
        int x = result.getX();
        int y = result.getY();
        assertEquals(-1, x);
        assertEquals(0, y);
    }


    @Test
    public void testMatrix25() {
        Coord result = logic.getMatrix(25).get(25);
        int x = result.getX();
        int y = result.getY();
        assertEquals(2, x);
        assertEquals(-2, y);
    }

    @Test
    public void testMatrix26() {
        Coord result = logic.getMatrix(26).get(26);
        int x = result.getX();
        int y = result.getY();
        assertEquals(3, x);
        assertEquals(-2, y);
    }

    @Test
    public void testMatrix27() {
        Coord result = logic.getMatrix(27).get(27);
        int x = result.getX();
        int y = result.getY();
        assertEquals(3, x);
        assertEquals(-1, y);
    }

    @Test
    public void testBidiMap() {
        BidiMap<Integer, Coord> test = logic.getMatrix(27);
        int testKey = test.getKey(new Coord(3,-1));
        assertEquals(27, testKey);
    }

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
}