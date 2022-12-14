package ar.edu.itba.ss;

import ar.edu.itba.ss.models.Particle;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class ParametersVariation {
    public static void main(String[] args) {
        final List<Integer> N = List.of(10, 25, 50, 100, 250, 500, 1000, 1500);
        final List<Double> noise = List.of(0.0, 0.1, 0.5, 1.0, 1.5, 2.0, 3.0, 4.0, 5.0);
        final int L = 10;
        final String extension = ".csv";

        N.forEach(particles -> noise.forEach(n -> {
            String staticFilename = String.format(Locale.ROOT ,"src/main/resources/input/parameters/static_N_%d_L_%d_n_%.1f%s", particles, L, n, extension);
            String dynamicFilename = String.format(Locale.ROOT ,"src/main/resources/input/parameters/dynamic_N_%d_L_%d_n_%.1f%s", particles, L, n, extension);
            String outputFilename = String.format(Locale.ROOT ,"parameters/output_N_%d_L_%d_n_%.1f.csv", particles, L, n);
            Particle.n = n;
            try {
                App.main(new String[]{staticFilename, dynamicFilename, outputFilename});
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Particle.sequence = 1;
        }));
    }
}
