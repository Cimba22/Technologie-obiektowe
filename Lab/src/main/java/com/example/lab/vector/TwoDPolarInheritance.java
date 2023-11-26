package com.example.lab.vector;

public class TwoDPolarInheritance extends Vector2D {
    public TwoDPolarInheritance(double x, double y) {
        super(x, y);
    }

    public double getAngle(){
        Vector2D oxVector = new Vector2D(1.0, 0.0);

        double cosAngle = (this.cdot(oxVector)) / (this.abs() * oxVector.abs());
        return Math.toDegrees(Math.acos(cosAngle));
    }

    @Override
    public String toString() {
        return "Two2DPolarInheritance kartesjanski {" +
                "x = " + getComponents()[0] +
                ", y = " + getComponents()[1] +
                "}\n" +
                "TwoDPolarInheritance biegunowy {" +
                "fi = " + this.getAngle() +
                ", r = " + this.abs() + "}";
    }
}
