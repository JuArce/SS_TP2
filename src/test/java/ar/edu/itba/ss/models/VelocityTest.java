package ar.edu.itba.ss.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VelocityTest {

    @Test
    public void getXSpeedTest() {
        final Velocity v = new Velocity(1, Math.PI / 4);
        assertEquals(0.7071, v.getXSpeed(), 0.0001);
    }

    @Test
    public void getYSpeedTest() {
        final Velocity v = new Velocity(1, Math.PI / 4);
        assertEquals(0.7071, v.getYSpeed(), 0.0001);
    }
}
