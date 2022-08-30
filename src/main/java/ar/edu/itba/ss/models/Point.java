package ar.edu.itba.ss.models;

import ar.edu.itba.ss.interfaces.Cloneable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Point implements Cloneable<Point> {
    protected double x;
    protected double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point point) {
        final double deltaX = this.x - point.x;
        final double deltaY = this.y - point.y;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    @SuppressWarnings("all")
    public Point clone() {
        return new Point(this.getX(), this.getY());
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
