package ar.edu.itba.ss.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
public class Particle {
    private static int SEQUENCE = 1;
    public static final double RC = 1.0;

    private int id;
    private Point position;
    private double radius;
    private final Set<Particle> neighbours;

    public Particle(double radius, Point position) {
        this.id = SEQUENCE++;
        this.radius = radius;
        this.position = position;
        this.neighbours = new HashSet<>();
    }

    public Particle(double radius) {
        this(radius, new Point(0, 0));
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

    public Set<Particle> getNeighbours() {
        return this.neighbours;
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
