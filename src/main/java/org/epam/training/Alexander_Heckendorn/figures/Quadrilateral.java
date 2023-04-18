package org.epam.training.Alexander_Heckendorn.figures;

class Quadrilateral extends Figure{
    public Quadrilateral(Point a, Point b, Point c, Point d){
        super(new Point[]{a , b , c , d});
    }

    @Override
    public double area() {
        Triangle triangle1 = new Triangle(vertices[0], vertices[1], vertices[2]);
        Triangle triangle2 = new Triangle(vertices[0], vertices[2], vertices[3]);
        return triangle1.area() + triangle2.area();
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
}
