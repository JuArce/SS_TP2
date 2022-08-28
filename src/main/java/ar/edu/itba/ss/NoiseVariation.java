package ar.edu.itba.ss;

import ar.edu.itba.ss.models.Particle;

import java.util.List;

public class NoiseVariation {
    public static void main(String[] args) {
        String particlePath = args[0];
        String positionPath = args[1];

        final List<Double> noise = List.of(0.0, 0.1, 0.5, 1.0, 1.5, 2.0);

        noise.forEach(n ->{
            String outputFilename = "noise/output_n_" + n + ".csv";
            Particle.n = n;
            App.main(new String[]{particlePath, positionPath, outputFilename});
            Particle.sequence = 1;
        });
    }
}
