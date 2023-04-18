package com.epam.training.Alexander_Heckendorn.figures;

class Circle extends Figure {
    private final Point center;
    private final double radius;

    public Circle(Point center, double radius){
        super(new Point[]{center});
        this.center = center;
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String pointsToString() {
        return String.format("%s", center);
    }

    @Override
    public Point leftmostPoint() {
        return new Point(center.getX() - radius, center.getY());
    }

    @Override
    public String toString() {
        return String.format("%s%.1f", super.toString(), radius);
    }
}
