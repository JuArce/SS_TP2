package ar.edu.itba.ss.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Particle {
    private static int SEQUENCE = 1;
    public static final double RC = 1.0;

    @Getter @Setter
    private int id;
    @Getter @Setter
    private double radius;
    @Getter @Setter
    private Point position;
    @Getter @Setter
    private Velocity velocity;
    @Getter
    private final Set<Particle> neighbours;

    public Particle(double radius, Point position, Velocity velocity) {
        this.id = SEQUENCE++;
        this.radius = radius;
        this.position = position;
        this.velocity = velocity;
        this.neighbours = new HashSet<>();
    }

    public Particle(int id, double radius, Point position, Velocity velocity, Set<Particle> neighbours) {
        this.id = id;
        this.radius = radius;
        this.position = position;
        this.velocity = velocity;
        this.neighbours = neighbours;
    }

    public Particle(double radius) {
        this(radius, new Point(0, 0), new Velocity(0, 0));
    }

    public void addNeighbour(Particle particle) {
        if (this.equals(particle)) {
            return;
        }
        this.neighbours.add(particle);
    }

    public boolean isNeighbour(Particle particle, double rc) {
        return !this.equals(particle) && this.distanceTo(particle) <= rc;
    }

    public boolean isNeighbour(Particle particle) {
        return this.isNeighbour(particle, Particle.RC);
    }

    public double distanceTo(Particle particle) {
        return this.position.distanceTo(particle.position) - this.radius - particle.radius;
    }

    public void setNeighbours(Set<Particle> candidates) {
        candidates.stream().filter(this::isNeighbour).forEach(this::addNeighbour);
    }

    @Override
    public String toString() {
        return "Particle{" +
                "id=" + id +
                ", position=" + position +
                ", radius=" + radius +
                ", neighbours=" + neighbours.stream().map(Particle::getId).toList() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Particle particle = (Particle) o;
        return id == particle.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
