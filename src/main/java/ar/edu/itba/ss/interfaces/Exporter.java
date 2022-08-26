package ar.edu.itba.ss.interfaces;

import ar.edu.itba.ss.models.Particle;

import java.util.List;
import java.util.Set;

public interface Exporter {
    void export(String filename, List<Set<Particle>> memento);
}