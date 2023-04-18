package com.epam.training.Alexander_Heckendorn.figures_extra;

class Quadrilateral extends Figure{
    public Quadrilateral(Point a, Point b, Point c, Point d){
        super(new Point[]{a , b , c , d});

        if (a == null || b == null || c == null || d == null) {
            throw new IllegalArgumentException("Quadrilateral contains null point(s).");
        }
        if (isDegenerate() || !isConvex()) {
            throw new IllegalArgumentException("Quadrilateral is not valid.");
        }
    }


    @Override
    public double area() {
        Triangle triangle1 = new Triangle(vertices[0], vertices[1], vertices[2]);
        Triangle triangle2 = new Triangle(vertices[0], vertices[2], vertices[3]);

        double sum = 0.0;
        double error = 0.0;

        double area1 = triangle1.area();
        double area2 = triangle2.area();

        double term1 = area1 + area2;
        double term2 = (term1 - area1) - area2;

        sum = term1 + error;
        error = term2 - error;

        return sum;
    }

    @Override
    public String pointsToString() {
        return String.format("%s%s%s%s", vertices[0], vertices[1], vertices[2], vertices[3]);
    }

    @Override
    public Point leftmostPoint() {
        Point leftmost = vertices[0];
        for (int i = 1; i < vertices.length; i++) {
            if (vertices[i].getX() < leftmost.getX()) {
                leftmost = vertices[i];
            }
        }
        return leftmost;
    }

    private boolean isConvex() {
        int n = vertices.length;
        boolean sign = false;
        for (int i = 0; i < n; i++) {
            double dx1 = vertices[(i + 2) % n].getX() - vertices[(i + 1) % n].getX();
            double dy1 = vertices[(i + 2) % n].getY() - vertices[(i + 1) % n].getY();
            double dx2 = vertices[i].getX() - vertices[(i + 1) % n].getX();
            double dy2 = vertices[i].getY() - vertices[(i + 1) % n].getY();
            double crossProduct = dx1 * dy2 - dy1 * dx2;
            if (i == 0) {
                sign = crossProduct > DELTA;
            } else if (sign != (crossProduct > DELTA)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDegenerate() {
        for (int i = 0; i < vertices.length; i++) {
            Point p1 = vertices[i];
            Point p2 = vertices[(i + 1) % vertices.length];
            Point p3 = vertices[(i + 2) % vertices.length];

            // Check if the three points are collinear
            double area = (p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) -
                    (p3.getX() - p1.getX()) * (p2.getY() - p1.getY());

            if (Math.abs(area) < DELTA) {
                // Points are collinear, so the quadrilateral is degenerate
                return true;
            }
        }
        return false;
    }
}
