package org.epam.training.Alexander_Heckendorn.line_intersection;

public class Line {
    private int k;
    private int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    //This refers to k1,b1 and other refers to k2,b2
    public Point intersection(Line other) {
        if(this.k == other.k && this.b == other.b){
            //This is if lines coincide or do not intersect
            return null;
        } else if(this.k == other.k){
            //Incase the lines are parrallel
            return null;
        } else{
            int x = (other.b - this.b) / (this.k - other.k);
            int y = this.k * x + this.b;
            return new Point(x,y);
        }

    }

}
