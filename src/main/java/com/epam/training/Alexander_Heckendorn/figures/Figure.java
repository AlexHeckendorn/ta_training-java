package com.epam.training.Alexander_Heckendorn.figures;

abstract class Figure{
    protected Point[] vertices;

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


}
