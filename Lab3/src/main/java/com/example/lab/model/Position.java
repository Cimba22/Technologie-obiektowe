package com.example.lab.model;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Position {
    private double x;
    private double y;

    private int moveCounter = 0;
    private int maxMoveCount = 100 / 25;


    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position(Pane world) {
        this(Person.radius + Math.random() * (world.getWidth() - 2 * Person.radius),
                Person.radius + Math.random() * (world.getHeight() - 2 * Person.radius));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Position other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) +
                Math.pow(this.y - other.y, 2));
    }

    public void move(Heading heading, Pane world) {
        x += heading.getDx();
        y += heading.getDy();
        Random random = new Random();

        moveCounter++;
        if (moveCounter >= maxMoveCount) {
            // Изменение направления
            heading.setDx(random.nextDouble() * 2 - 1); // Генерация случайной скорости по оси X от -1 до 1
            heading.setDy(random.nextDouble() * 2 - 1); // Генерация случайной скорости по оси Y от -1 до 1
            moveCounter = 0; // Сброс счетчика
        }

        //Отвечают за чтобы люди не выходили за границы
        if (x < Person.radius || x > world.getWidth() - Person.radius) {
            if (random.nextDouble() < 0.5) {
//                heading.bounceX();
                x += heading.getDx();
            }
        }
        if (y < Person.radius || y > world.getHeight() - Person.radius) {
            if (random.nextDouble() < 0.5) {
//                heading.bounceY();
                y += heading.getDy();
            }
        }
    }

    public boolean collision(Position other) {
        return distance(other) < 2 * Person.radius;
    }







}
