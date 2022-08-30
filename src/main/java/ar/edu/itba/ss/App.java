package ar.edu.itba.ss;

import ar.edu.itba.ss.models.Grid;
import ar.edu.itba.ss.models.OffLattice;
import ar.edu.itba.ss.models.Particle;
import ar.edu.itba.ss.tools.CsvExporter;
import ar.edu.itba.ss.interfaces.Exporter;
import ar.edu.itba.ss.tools.ParticleReader;

import java.lang.reflect.Field;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Run the simulation.
 */
public class App {
    public static void main(String[] args) {
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

        OffLattice offLattice = new OffLattice(dt, iterations, grid);
        offLattice.simulate();

        Instant end = Instant.now();
        System.out.println("Simulation: " + Duration.between(start, end));

        start = Instant.now();
        Exporter exporter = new CsvExporter();
        exporter.export(outputFilename, offLattice.getMemento());
        end = Instant.now();
        System.out.println("Export to CSV: " + Duration.between(start, end));
    }
}
