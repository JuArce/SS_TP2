package ar.edu.itba.ss.models;

import ar.edu.itba.ss.interfaces.Movable;
import ar.edu.itba.ss.tools.Random;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Particle implements Movable {
    public static int sequence = 1;
    public static final double RC = 1.0;
    public static double n = 0.1;

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private double radius;
    @Getter
    @Setter
    private Point position;
    @Getter
    @Setter
    private Velocity velocity;
    @Setter
    private Velocity nextVelocity;
    @Getter
    private Set<Particle> neighbours;

    public Particle(double radius, Point position, Velocity velocity) {
        this.id = sequence++;
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

    public void setNeighbours(Set<Particle> candidates) {
        this.neighbours = new HashSet<>();
        candidates.stream().filter(this::isNeighbour).forEach(this::addNeighbour);
    }

    public boolean isNeighbour(Particle particle, double rc) {
        double distance = this.distanceTo(particle);
        return !this.equals(particle) && (distance < rc || Math.abs(distance - rc) < 0.00000001);
    }

    public boolean isNeighbour(Particle particle) {
        return this.isNeighbour(particle, Particle.RC);
    }

    public void addNeighbour(Particle particle) {
        if (this.equals(particle)) {
            return;
        }
        this.neighbours.add(particle);
    }

    public double distanceTo(Particle particle) {
        return this.position.distanceTo(particle.position) - this.radius - particle.radius;
    }

    @Override
    public void move(double dt) {
        this.position.setX(this.position.getX() + this.velocity.getXSpeed() * dt);
        this.position.setY(this.position.getY() + this.velocity.getYSpeed() * dt);
    }

    public void calculateVelocity() {
        final Set<Particle> particles = new HashSet<>(this.neighbours);
        particles.add(this);
        final double noise = Random.getRandom(-n / 2.0, n / 2.0);
        double y = particles.stream()
                .map(p -> p.getVelocity().getAngle())
                .map(Math::sin)
                .collect(Collectors.averagingDouble(a -> a));
        double x = particles.stream()
                .map(p -> p.getVelocity().getAngle())
                .map(Math::cos)
                .collect(Collectors.averagingDouble(a -> a));
        double angle = Math.atan2(y, x) + noise;
        this.nextVelocity = new Velocity(this.velocity.getSpeed(), angle);
    }

    public void updateVelocity() {
        this.velocity = this.nextVelocity;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", this.id, this.position.getX(), this.position.getY(), this.velocity.getSpeed(), this.velocity.getAngle());
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
