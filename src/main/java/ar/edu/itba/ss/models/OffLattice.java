package ar.edu.itba.ss.models;

import ar.edu.itba.ss.interfaces.Exporter;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OffLattice {
    private double dt;
    private int iterations;
    private Grid grid;
    private final Exporter exporter;

    public OffLattice(double dt, int iterations, Grid grid, Exporter exporter) {
        this.dt = dt;
        this.iterations = iterations;
        this.grid = grid;
        this.exporter = exporter;
    }

    public void simulate() {
        for (int i = 0; i < this.iterations; i++) {
            this.exporter.export(i, this.grid.getParticles());
            this.grid.update(dt);
            if (i % 100 == 0) {
                System.out.println("Iteration: " + i);
            }
        }
    }

}
