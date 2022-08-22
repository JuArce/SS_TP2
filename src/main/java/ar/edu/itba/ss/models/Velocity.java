package ar.edu.itba.ss.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Velocity {
    private double speed;
    private double angle;

    public Velocity(double speed, double angle) {
        this.speed = speed;
        this.angle = angle;
    }

    public double getXSpeed() {
        return this.speed * Math.cos(this.angle);
    }

    public double getYSpeed() {
        return this.speed * Math.sin(this.angle);
    }
}
