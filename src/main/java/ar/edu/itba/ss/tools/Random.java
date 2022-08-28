package ar.edu.itba.ss.tools;

import java.util.concurrent.ThreadLocalRandom;

public class Random {
    public static double getRandom(double min, double max) {
        if (min >= max) {
            return 0;
        }
        return ThreadLocalRandom.current().nextDouble(min, max);
    }
}
