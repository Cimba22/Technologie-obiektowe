package com.example.lab.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Person {


    public static int radius = 5;


    private State state;
    private Position loc;
    private Heading heading;
    private Circle c;
    private Pane world;
    private int sickTime = 0;
    private int timeOfContact;
    private static final Random random = new Random();


    public Person(State state, Pane world) {
        this.state = state;
        this.heading = new Heading();
        this.loc = new Position(world);
        this.c = new Circle(radius, state.getColor());
        this.world = world;
        c.setStroke(Color.BLACK);
        world.getChildren().add(c);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        c.setFill(state.getColor());
    }

    public void move() {
        loc.move(heading, world);
    }

    public void draw() {
        c.setRadius(radius);
        c.setTranslateX(loc.getX());
        c.setTranslateY(loc.getY());
    }






    //При столкновении с незараженным - заражает.
    public void collisionCheck(Person other) {
        if (loc.collision(other.loc)) {
            timeOfContact++;
        }else timeOfContact = 0;

        if (timeOfContact >= 2){
            if (other.getState() == State.INFECTED && state == State.SUSCEPTIBLE) {
                setState(State.INFECTED);
//                System.out.println("jest1");
            }
            if (other.getState() == State.INFECTED && state == State.HAVE_SYMPTOMS) {
                setState(State.INFECTED);
//                System.out.println("jest2");
            }
            if (other.getState() == State.HAVE_SYMPTOMS && state == State.SUSCEPTIBLE) {
                setState(State.INFECTED);
//                System.out.println("jest4");
            }

        }

    }

    private int counter = 0;
    public void goInfected() {
        counter++;
        if (counter % 300 == 0) {
            if (random.nextInt(5) == 1 && state == State.HAVE_SYMPTOMS) {
                setState(State.INFECTED);
//                System.out.println("jest3");
            }
            if (random.nextInt(10) == 1 && state == State.SUSCEPTIBLE) {
                setState(State.INFECTED);
//                System.out.println("jest5");
            }
        }
    }



    public void feelBetter() {
        int min = 10; // Минимальное значение (20 / 2)
        int max = 15; // Максимальное значение (30 / 2)
        if(state == State.INFECTED) {
            int healTime = ThreadLocalRandom.current().nextInt(min, max + 1) * 2;
            sickTime++;
            if (sickTime > healTime * 30){
                setState(State.RECOVERED);
                sickTime = 0;
            }
        }
    }


    public void drawOutOfBoundary() {
        double x, y;
        Random random = new Random();
        if (random.nextBoolean()) {
            // Сгенерировать точку по горизонтали
            x = random.nextBoolean() ? -random.nextDouble(world.getWidth()) : world.getWidth() + random.nextDouble(world.getWidth());
            y = random.nextDouble(world.getHeight());
        } else {
            // Сгенерировать точку по вертикали
            x = random.nextDouble(world.getWidth());
            y = random.nextBoolean() ? -random.nextDouble(world.getHeight()) : world.getHeight() + random.nextDouble(world.getHeight());
        }
        c.setRadius(radius);
        c.setTranslateX(x);
        c.setTranslateY(y);
    }
}
