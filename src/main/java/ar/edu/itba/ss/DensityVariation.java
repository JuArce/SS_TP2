package ar.edu.itba.ss;

import ar.edu.itba.ss.models.Particle;

import java.util.List;

public class DensityVariation {
    public static void main(String[] args) {
        final List<Integer> N = List.of(10, 25, 50, 100, 250, 500, 1000, 1500);

        for(int n : N) {
            String staticFilename = "src/main/resources/input/density/static_" + n + ".csv";
            String dynamicFilename = "src/main/resources/input/density/dynamic_" + n + ".csv";
            String outputFilename = "density/output_N_" + n + ".csv";
            App.main(new String[]{staticFilename, dynamicFilename, outputFilename});
            Particle.sequence = 1;
        }
    }
}
