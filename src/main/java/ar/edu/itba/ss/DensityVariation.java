package ar.edu.itba.ss;

import ar.edu.itba.ss.models.Particle;

import java.util.List;

public class DensityVariation {
    public static void main(String[] args) {
        final List<Integer> N = List.of(10, 25, 50, 100, 250, 500, 1000, 1500);
        final List<Double> noise = List.of(0.0, 1.0, 5.0);
        final int L = 10;

        for(int n : N) {
            String staticFilename = "src/main/resources/input/density/static_" + n + ".csv";
            String dynamicFilename = "src/main/resources/input/density/dynamic_" + n + ".csv";
            String outputFilename = "density/output_N_" + n + ".csv";
            App.main(new String[]{staticFilename, dynamicFilename, outputFilename});
            Particle.sequence = 1;
        }
        N.forEach(particles -> noise.forEach(n -> {
            String staticFilename = String.format("src/main/resources/input/density/static_N_%d_L_%d_n_%f.csv", particles, L, n);
            String dynamicFilename = String.format("src/main/resources/input/density/dynamic_N_%d_L_%d_n_%f.csv", particles, L, n);
            String outputFilename = String.format("density/output_N_%d_L_%d_n_%f.csv", particles, L, n);
            Particle.n = n;
            App.main(new String[]{staticFilename, dynamicFilename, outputFilename});
            Particle.sequence = 1;
        }));
    }
}
