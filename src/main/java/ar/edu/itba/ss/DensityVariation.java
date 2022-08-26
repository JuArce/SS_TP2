package ar.edu.itba.ss;

import java.util.List;

public class DensityVariation {
    public static void main(String[] args) {
        final List<Integer> N = List.of(40, 100, 200, 300, 400, 500, 1000, 2000, 3000, 4000);

        for(int n : N) {
            String staticFilename = "src/main/resources/input/density/static_" + n + ".csv";
            String dynamicFilename = "src/main/resources/input/density/dynamic_" + n + ".csv";
            String outputFilename = "density/output_" + n + ".csv";
            App.main(new String[]{staticFilename, dynamicFilename, outputFilename});
        }
    }
}
