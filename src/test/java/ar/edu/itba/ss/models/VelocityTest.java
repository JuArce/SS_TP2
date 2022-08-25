package ar.edu.itba.ss.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

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

    @Test
    public void cloneTest() {
        final Velocity v1 = new Velocity(1, Math.PI / 4);
        final Velocity v2 = v1.clone();
        assertNotSame(v1, v2);
        assertEquals(v1.getSpeed(), v2.getSpeed(), 0.0001);
        assertEquals(v1.getAngle(), v2.getAngle(), 0.0001);
    }
}
