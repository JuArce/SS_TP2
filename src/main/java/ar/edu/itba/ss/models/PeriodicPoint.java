package ar.edu.itba.ss.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeriodicPoint extends Point {
    private double side;

    public PeriodicPoint(double x, double y, double side) {
        super(x, y);
        this.side = side;
    }

    @Override
    public double distanceTo(Point point) {
        final double auxDeltaX = Math.abs(this.x - point.x);
        final double deltaX = Double.min(auxDeltaX, this.side - auxDeltaX);

        final double auxDeltaY = Math.abs(this.y - point.y);
        final double deltaY = Double.min(auxDeltaY, this.side - auxDeltaY);

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public void setX(double x) {
        super.setX((x + side) % side);
    }

    @Override
    public void setY(double y) {
        super.setY((y + side) % side);
    }
}
