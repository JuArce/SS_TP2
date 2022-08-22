package ar.edu.itba.ss.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OffLattice {
    private double dt;
    private int iterations;
    private Grid grid;

    public OffLattice(double dt, int iterations, Grid grid) {
        this.dt = dt;
        this.iterations = iterations;
        this.grid = grid;
    }

    public void simulate() {
        for (int i = 0; i < this.iterations; i++) {

            this.grid.update(dt);
        }
    }

}
