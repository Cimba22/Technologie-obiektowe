package com.example.lab.model;


import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class Simulation {

    private static final int PROBABILITY_OF_ILL = 10;
    private static final int PROBABILITY_OF_HAVING_SYMPTOMS = 2;
    private static final int PROBABILITY_OF_IMMUNE = 2;
    private static final int PROBABILITY_OF_INFECTED = 2;
    private static final int PROBABILITY_OF_ENTRY_INTO_ROOM = 2;
    private ArrayList<Person> people;
    private static final Random random = new Random();
    private int counter;

    public Simulation(Pane world, int popSize) {
        people = new ArrayList<Person>();

        for (int i = 0; i < popSize; i++) {
            if (random.nextInt(PROBABILITY_OF_HAVING_SYMPTOMS) == 1) {
                people.add(new Person(State.HAVE_SYMPTOMS, world));
            }
            if (random.nextInt(PROBABILITY_OF_IMMUNE) == 1){
                people.add(new Person(State.IMMUNE, world));
            }
            if (random.nextInt(PROBABILITY_OF_INFECTED) == 1){
                people.add(new Person(State.INFECTED, world));
            }
            people.add(new Person(State.SUSCEPTIBLE, world));
        }
        people.add(new Person(State.INFECTED, world));
        draw();
//        drawOutOfBoundary();

    }

    public void drawOutOfBoundary() {
        for (Person p : people) {
            p.drawOutOfBoundary();
        }
    }

    public void getStatus() {
        int h = 0, i = 0;
        for (Person p : people) {
            if (p.getState() == State.INFECTED) i++;
            if (p.getState() == State.RECOVERED) h++;
        }
        System.out.println("INFECTED: " + i + ";  " + "RECOVERED: " + h);
    }


    public ArrayList<Person> getPeople() {
        return people;
    }

    public void move() {
        for (Person p: people) {
            p.move();
        }
    }

    public void draw() {
        for (Person p : people) {
            p.draw();
        }
    }



    //Проверка при столкновении каждого с каждым на заражение
    public void resolveCollisions() {
        for (Person p : people) {
            for (Person q : people) {
                if (p != q) {
                    p.collisionCheck(q);
                }
            }
        }
    }

    public void goInfecting() {
        for (Person p : people) {
            p.goInfected();
        }
    }

    public void feelBetter() {
        for (Person p : people) {
            p.feelBetter();
        }
    }
}
