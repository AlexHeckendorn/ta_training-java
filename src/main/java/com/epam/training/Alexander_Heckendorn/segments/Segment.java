package com.epam.training.Alexander_Heckendorn.segments;

import static java.lang.Math.abs;

class Segment {
    private final Point start;
    private final Point end;

    public Segment(Point start, Point end) {
        System.out.println("Start point: " + start.getX() + ", " + start.getY());
        System.out.println("End point: " + end.getX() + ", " + end.getY());
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException("Start and end points cannot have the same values");
        }
        this.start = start;
        this.end = end;
    }

    double length() {
        return start.distance(end);
    }


    Point middle() {
        double x = (start.getX() + end.getX()) / 2.0;
        double y = (start.getY() + end.getY()) / 2.0;
        return new Point(x,y);
    }

    Point intersection(Segment another) {
        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = end.getX();
        double y2 = end.getY();
        double x3 = another.start.getX();
        double y3 = another.start.getY();
        double x4 = another.end.getX();
        double y4 = another.end.getY();
        double denominator = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
        //Incase the segments are parallel || collinear
        if (denominator == 0) {
            return null;
        }
        double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / denominator;
        double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / denominator;
        // segments intersect
        if (ua >= 0 && ua <= 1 && ub >= 0 && ub <= 1) {
            double x = x1 + ua * (x2 - x1);
            double y = y1 + ua * (y2 - y1);
            return new Point(x, y);
        // segments do not intersect
        } else {
            return null;
        }
    }

}
