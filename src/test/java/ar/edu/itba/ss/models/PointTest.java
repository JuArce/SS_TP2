package ar.edu.itba.ss.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    private static final double DELTA = 0.0001;

    @Test
    public void distanceToTest() {
        final Point p1 = new Point(1, 1);
        final Point p2 = new Point(4, 5);
        assertEquals(5.0, p1.distanceTo(p2), 0.0001);
    }

    @Test
    public void cloneTest() {
        final Point p1 = new Point(1, 1);
        final Point p2 = p1.clone();
        assertNotSame(p1, p2);
        assertEquals(p1.getX(), p2.getX(), DELTA);
        assertEquals(p1.getY(), p2.getY(), DELTA);
    }
}
