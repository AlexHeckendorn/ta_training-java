package org.epam.training.Alexander_Heckendorn.segments;

class Point {
    private final double x;
    private final double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    //Method to calculate distance utilizing pythagorean theorem
    public double distance(Point other) {
        double deltaX = other.x - x;
        double deltaY = other.y - y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

