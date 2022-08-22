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
    public Point clone() {
        Point p;
        try {
            p = (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            p = new Point(this.getX(), this.getY());
        }
        return p;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
