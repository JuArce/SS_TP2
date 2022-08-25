package ar.edu.itba.ss.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParticleTest {

    @Test
    public void distanceToTest() {
        final Particle p1 = new Particle(0.5, new Point(1, 1), new Velocity(0, 0));
        final Particle p2 = new Particle(0.5, new Point(4, 5), new Velocity(0, 0));
        assertEquals(4.0, p1.distanceTo(p2), 0.0001);
    }

    @Test
    public void isNeighbourTest() {
        final Particle p1 = new Particle(0.5, new Point(1, 1), new Velocity(0, 0));
        final Particle p2 = new Particle(0.5, new Point(1, 1.5), new Velocity(0, 0));
        assertTrue(p1.isNeighbour(p2, 1.0));
    }

    @Test
    public void isNotNeighbourTest() {
        final Particle p1 = new Particle(0.5, new Point(1, 1), new Velocity(0, 0));
        final Particle p2 = new Particle(0.5, new Point(4, 5), new Velocity(0, 0));
        assertFalse(p1.isNeighbour(p2, 1.0));
    }

    @Test
    public void moveTest() {
        final Particle p = new Particle(0.5, new Point(1, 1), new Velocity(1, Math.PI / 4));
        p.move(1.0);
        assertEquals(1.7071, p.getPosition().getX(), 0.0001);
        assertEquals(1.7071, p.getPosition().getY(), 0.0001);
    }

    @Test
    public void cloneTest() {
        final Particle p1 = new Particle(0.5, new Point(1, 1), new Velocity(1, Math.PI / 4));
        final Particle p2 = p1.clone();
        assertNotSame(p1, p2);
        assertEquals(p1.getId(), p2.getId());
        assertEquals(p1.getRadius(), p2.getRadius(), 0.0001);
        assertEquals(p1.getPosition().getX(), p2.getPosition().getX(), 0.0001);
        assertEquals(p1.getPosition().getY(), p2.getPosition().getY(), 0.0001);
        assertEquals(p1.getVelocity().getSpeed(), p2.getVelocity().getSpeed(), 0.0001);
        assertEquals(p1.getVelocity().getAngle(), p2.getVelocity().getAngle(), 0.0001);
    }
}
