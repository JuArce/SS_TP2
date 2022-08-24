package ar.edu.itba.ss.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
public class OffLattice {
    private double dt;
    private int iterations;
    private Grid grid;
    @Getter
    private final List<Set<Particle>> memento = new ArrayList<>();

    public OffLattice(double dt, int iterations, Grid grid) {
        this.dt = dt;
        this.iterations = iterations;
        this.grid = grid;
    }

    public void simulate() {
        for (int i = 0; i < this.iterations; i++) {
            this.memento.add(this.grid.getParticlesClone());
            this.grid.update(dt);
            System.out.println("Iteration " + i);
        }
    }

}
