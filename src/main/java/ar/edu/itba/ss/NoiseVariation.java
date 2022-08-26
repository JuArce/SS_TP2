package ar.edu.itba.ss;

import ar.edu.itba.ss.models.Particle;

public class NoiseVariation {
    public static void main(String[] args) {
        String particlePath = args[0];
        String positionPath = args[1];

        for(int i = 1; i < 10; i++) {
            String outputFilename = "noise/output_n_" + i + ".csv";
            Particle.n = i;
            App.main(new String[]{particlePath, positionPath, outputFilename});
        }
    }
}
