package ar.edu.itba.ss;

import ar.edu.itba.ss.models.Particle;
import ar.edu.itba.ss.models.Point;
import ar.edu.itba.ss.models.Velocity;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import static ar.edu.itba.ss.tools.Random.getRandom;

public class Generator {

    public static void main(String[] args) {
        final int L = 100;
        final int N = 1000;
        final double r = 1.0;
        final double minRandomPosition = 0 + r;
        final double maxRandomPosition = L - r;
        final double speed = 0.3;
        final double minRandomAngle = 0;
        final double maxRandomAngle = 2 * Math.PI;

        final String staticNFile = "src/main/resources/input/staticN.txt";
        final String dynamicNFile = "src/main/resources/input/dynamicN.txt";

        final List<Particle> particles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Particle p = new Particle(r,
                    new Point(getRandom(minRandomPosition, maxRandomPosition), getRandom(minRandomPosition, maxRandomPosition)),
                    new Velocity(speed, getRandom(minRandomAngle, maxRandomAngle)));
            particles.add(p);
        }

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(staticNFile), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
            writer.writeNext(new String[]{String.valueOf(particles.size())});
            writer.writeNext(new String[]{String.valueOf(L)});
            particles.forEach(p -> {
                List<String> line = new ArrayList<>();
                line.add(String.valueOf(r));
                writer.writeNext(line.toArray(new String[0]));
            });
            writer.close();
        } catch (Exception e) {
            e.printStackTrace(); //TODO: handle exception
        }

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(dynamicNFile), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
            writer.writeNext(new String[]{String.valueOf(0)});
            particles.forEach(p -> {
                List<String> line = new ArrayList<>();
                line.add(String.valueOf(p.getPosition().getX()));
                line.add(String.valueOf(p.getPosition().getY()));
                line.add(String.valueOf(p.getVelocity().getSpeed()));
                line.add(String.valueOf(p.getVelocity().getAngle()));
                writer.writeNext(line.toArray(new String[0]));
            });
            writer.close();
        } catch (Exception e) {
            e.printStackTrace(); //TODO: handle exception
        }
    }
}
