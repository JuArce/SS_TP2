package ar.edu.itba.ss.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PeriodicPointTest {

    private static final double DELTA = 0.0001;

    @Test
    public void distanceToTest() {
        final PeriodicPoint p1 = new PeriodicPoint(1, 1, 10);
        final PeriodicPoint p2 = new PeriodicPoint(4, 5, 10);
        assertEquals(5.0, p1.distanceTo(p2), DELTA);
    }

    @Test
    public void distanceToPeriodicTest() {
        final PeriodicPoint p1 = new PeriodicPoint(1, 1, 10);
        final PeriodicPoint p2 = new PeriodicPoint(9, 9, 10);
        assertEquals(2.8284, p1.distanceTo(p2), DELTA);
    }

    @Test
    public void setXPeriodicTest() {
        final Point p = new PeriodicPoint(1, 1, 10);
        p.setX(11);
        assertEquals(1.0, p.getX(), DELTA);
    }

    @Test
    public void setYPeriodicTest() {
        final Point p = new PeriodicPoint(1, 1, 10);
        p.setY(11);
        assertEquals(1.0, p.getY(), DELTA);
    }

    @Test
    public void setXYPeriodicTest() {
        final Point p = new PeriodicPoint(1, 1, 10);
        p.setX(11);
        p.setY(11);
        assertEquals(1.0, p.getX(), DELTA);
        assertEquals(1.0, p.getY(), DELTA);
    }
}
