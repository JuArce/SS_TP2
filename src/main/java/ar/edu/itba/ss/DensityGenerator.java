package ar.edu.itba.ss;

import ar.edu.itba.ss.models.Particle;

import java.util.List;

public class DensityGenerator {
    public static void main(String[] args) {
        final List<Integer> N = List.of(10, 25, 50, 100, 250, 500, 1000, 1500);
        final int L = 10;
        final String staticPrefix = "density/static_";
        final String dynamicPrefix = "density/dynamic_";
        final String extension = ".csv";

        for(int n : N) {
            String staticFilename = staticPrefix + n + extension;
            String dynamicFilename = dynamicPrefix + n + extension;
            Generator.main(new String[]{String.valueOf(n), String.valueOf(L), staticFilename, dynamicFilename});
            Particle.sequence = 1;
        }
    }
}
