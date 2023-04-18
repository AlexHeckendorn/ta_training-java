package com.epam.training.Alexander_Heckendorn.figures_extra;

abstract class Figure{
    protected Point[] vertices;
    static final double DELTA = 1e-6;
    public Figure(Point[] vertices){
        this.vertices = vertices;
    }

    public abstract double area();

    public abstract String pointsToString();
    public abstract Point leftmostPoint();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    public boolean isTheSame(Figure figure) {
        if (this.getClass() != figure.getClass()) {
            return false;
        }
        
        Point[] otherVertices = figure.vertices;
        if (this.vertices.length != otherVertices.length) {
            return false;
        }
        boolean[] used = new boolean[otherVertices.length];
        for (Point p1 : this.vertices) {
            boolean found = false;
            for (int i = 0; i < otherVertices.length; i++) {
                if (!used[i] && p1.distance(otherVertices[i]) < 1e-6) {
                    used[i] = true;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public Point centroid() {
        double area = 0;
        double cx = 0;
        double cy = 0;

        for (int i = 0; i < vertices.length; i++) {
            int j = (i + 1) % vertices.length;
            double cross = vertices[i].getX() * vertices[j].getY() - vertices[j].getX() * vertices[i].getY();
            area += cross;
            cx += (vertices[i].getX() + vertices[j].getX()) * cross;
            cy += (vertices[i].getY() + vertices[j].getY()) * cross;
        }

        area /= 2;
        cx /= 6 * area;
        cy /= 6 * area;

        return new Point(cx, cy);
    }



}
