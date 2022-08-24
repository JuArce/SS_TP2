package ar.edu.itba.ss.tools;

import ar.edu.itba.ss.models.Particle;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class CsvExporter implements Exporter {

    @Override
    public void export(String filename, List<Set<Particle>> memento) {
        AtomicInteger i = new AtomicInteger(0);
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/output/" + filename), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
            writer.writeNext(new String[]{"iteration", "id", "x", "y", "speed", "angle"});
            memento.forEach(particles -> {
                particles.forEach(p -> {
                    String line = i.get() + " " + p.toString();
                    writer.writeNext(line.split(" "));
                });
                i.incrementAndGet();
            });
            writer.close();

        } catch (Exception e) {
            e.printStackTrace(); //TODO: handle exception
        }
    }
}
