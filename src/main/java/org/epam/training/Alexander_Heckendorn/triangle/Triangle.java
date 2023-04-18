package org.epam.training.Alexander_Heckendorn.triangle;

class Triangle {
    private final Point p1;
    private final Point p2;
    private final Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        double area = Math.abs((p1.getX() - p3.getX()) * (p2.getY() - p1.getY())
                - (p1.getX() - p2.getX()) * (p3.getY() - p1.getY())) / 2;
        if (area == 0) {
            throw new IllegalArgumentException("Degenerate triangle");
        }
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }


    public double area() {
        return Math.abs((p1.getX() - p3.getX()) * (p2.getY() - p1.getY())
                - (p1.getX() - p2.getX()) * (p3.getY() - p1.getY())) / 2;
    }


    public Point centroid() {
        double cx = (p1.getX() + p2.getX() + p3.getX()) / 3.0;
        double cy = (p1.getY() + p2.getY() + p3.getY()) / 3.0;
        return new Point(cx, cy);
    }

}
