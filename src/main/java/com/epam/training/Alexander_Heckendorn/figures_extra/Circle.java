package com.epam.training.Alexander_Heckendorn.figures_extra;

class Circle extends Figure {
    private final Point center;
    private final double radius;

    public Circle(Point center, double radius){
        super(new Point[]{center});
        if (center == null) {
            throw new IllegalArgumentException("Center point cannot be null");
        }
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
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

    @Override
    public Point centroid() {
        return center;
    }


}

