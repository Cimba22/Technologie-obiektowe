package com.example.lab.model;

public class Heading {

//    nie większa niż 2.5[ms/s]
    public static final double SPEED = 2;
    private double dx;
    private double dy;

    public Heading(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }


    //случайное направление движения в двумерном пространстве.
    public Heading() {
        double dir = Math.random() * 2 * Math.PI;
        dx = Math.sin(dir);
        dy = Math.cos(dir);
    }


    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public void bounceX(){
        dx *= -1;
    }
    public void bounceY(){
        dy *= -1;
    }
}
