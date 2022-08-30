package ar.edu.itba.ss;

import ar.edu.itba.ss.models.Grid;
import ar.edu.itba.ss.models.OffLattice;
import ar.edu.itba.ss.models.Particle;
import ar.edu.itba.ss.tools.CsvExporter;
import ar.edu.itba.ss.interfaces.Exporter;
import ar.edu.itba.ss.tools.ParticleReader;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Run the simulation.
 */
public class App {
    public static void main(String[] args) throws IOException {
        final double dt = 1;
        final int iterations = 2000;

        String particlePath = args[0];
        String positionPath = args[1];
        boolean isPeriodic = true;
        String outputFilename = args.length < 3 ? "output.csv" : args[2];

        Instant start = Instant.now();

        ParticleReader particleReader = new ParticleReader(particlePath, positionPath);
        List<Particle> particles = new ArrayList<>();
        int l = particleReader.read(particles, isPeriodic);

        Grid grid = new Grid(l, particles, isPeriodic);

        Exporter exporter = new CsvExporter(outputFilename);
        exporter.open();

        OffLattice offLattice = new OffLattice(dt, iterations, grid, exporter);
        offLattice.simulate();

        exporter.close();

        Instant end = Instant.now();
        System.out.println("Simulation: " + Duration.between(start, end));
    }
}
