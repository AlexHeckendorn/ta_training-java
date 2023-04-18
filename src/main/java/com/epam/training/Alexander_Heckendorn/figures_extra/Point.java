package com.epam.training.Alexander_Heckendorn.figures_extra;

import java.awt.geom.Point2D;

class Point {
    private final double x;
    private final double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point other) {
        Point2D p1 = new Point2D.Double(this.x, this.y);
        Point2D p2 = new Point2D.Double(other.getX(), other.getY());
        return p1.distance(p2);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}

