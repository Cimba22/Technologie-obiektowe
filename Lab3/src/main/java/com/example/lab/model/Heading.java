package com.example.lab.model;

import java.util.Random;

public class Heading {

    private static final Random random = new Random();
    //    nie większa niż 2.5[ms/s]
    public static final double SPEED = 2.5;
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
        return dx * SPEED;
    }

    public double getDy() {
        return dy * SPEED;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public void bounceX(){
        dx *= -1;
    }
    public void bounceY(){
        dy *= -1;
    }
}
