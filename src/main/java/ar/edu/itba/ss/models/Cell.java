package ar.edu.itba.ss.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Cell {
    private Set<Particle> particles;

    public Cell() {
        this.particles = new HashSet<>();
    }

    public void addParticle(Particle particle) {
        this.particles.add(particle);
    }
}
