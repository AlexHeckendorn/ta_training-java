package org.epam.training.Alexander_Heckendorn.figures;

class Triangle extends Figure{

    public Triangle(Point a, Point b, Point c){
        super(new Point[]{a , b , c});
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
}
