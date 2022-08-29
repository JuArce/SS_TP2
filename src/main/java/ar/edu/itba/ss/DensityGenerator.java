package ar.edu.itba.ss;

import ar.edu.itba.ss.models.Particle;

import java.util.List;

public class DensityGenerator {
    public static void main(String[] args) {
        final List<Integer> N = List.of(10, 25, 50, 100, 250, 500, 1000, 1500);
        final List<Double> noise = List.of(0.0, 1.0, 5.0);
        final int L = 10;
        final String extension = ".csv";

        N.forEach(particles -> noise.forEach(n -> {
            String staticFilename = String.format("density/static_N_%d_L_%d_n_%f_%s", particles, L, n, extension);
            String dynamicFilename = String.format("density/dynamic_N_%d_L_%d_n_%f_%s", particles, L, n, extension);
            Particle.n = n;
            Generator.main(new String[]{String.valueOf(particles), String.valueOf(L), staticFilename, dynamicFilename});
            Particle.sequence = 1;
        }));
    }
}
