package org.epam.training.Alexander_Heckendorn.figures_extra;

class Triangle extends Figure{

    public Triangle(Point a, Point b, Point c){
        super(new Point[]{a , b , c});

        // check for degenerative cases
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException("Invalid triangle: null points");
        }

        double area = Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY())
                - (c.getX() - a.getX()) * (b.getY() - a.getY()));
        if (area < DELTA) {
            throw new IllegalArgumentException("Invalid triangle: collinear points");
        }
    }


    @Override
    public double area() {
        double side1 = vertices[0].distance(vertices[1]);
        double side2 = vertices[1].distance(vertices[2]);
        double side3 = vertices[2].distance(vertices[0]);
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public String pointsToString() {
        return String.format("%s%s%s", vertices[0], vertices[1], vertices[2]);
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

    @Override
    public Point centroid() {
        double x = (vertices[0].getX() + vertices[1].getX() + vertices[2].getX()) / 3;
        double y = (vertices[0].getY() + vertices[1].getY() + vertices[2].getY()) / 3;
        return new Point(x, y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Triangle) {
            Triangle other = (Triangle) figure;
            Point[] otherVertices = other.vertices;
            for (Point vertex : vertices) {
                boolean found = false;
                for (Point otherVertex : otherVertices) {
                    if (vertex.distance(otherVertex) < 1e-6) {
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
        return false;
    }
}

