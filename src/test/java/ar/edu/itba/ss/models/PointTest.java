package ar.edu.itba.ss.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    private static final double DELTA = 0.0001;

    @Test
    public void distanceToTest() {
        final Point p1 = new Point(1, 1);
        final Point p2 = new Point(4, 5);
        assertEquals(5.0, p1.distanceTo(p2), DELTA);
    }
}
