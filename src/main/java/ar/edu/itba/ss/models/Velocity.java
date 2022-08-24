package ar.edu.itba.ss.models;

import ar.edu.itba.ss.interfaces.Cloneable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Velocity implements Cloneable<Velocity> {
    private double speed;
    private double angle;

    // Polar coordinates
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

    @Override
    public Velocity clone() {
        Velocity v;
        try {
            v = (Velocity) super.clone();
        } catch (CloneNotSupportedException e) {
            v = new Velocity(this.speed, this.angle);
        }
        return v;
    }

    @Override
    public String toString() {
        return "Velocity{" +
                "speed=" + speed +
                ", angle=" + angle +
                '}';
    }
}
