package com.example.lab;

import com.example.lab.model.Simulation;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class SocialSimController {
    @FXML
    Pane world;

    @FXML
    Button startButton;

    @FXML
    Button stopButton;

    @FXML
    Button stepButton;
    Simulation sim;

    private Movement clock;

    private class Movement extends AnimationTimer {

        private long FRAMES_PER_SEC = 50L;
        private long INTERVAL = 1_000_000_000 / FRAMES_PER_SEC;
        private long last = 0;
        @Override
        public void handle(long now) {
            if (now - last > INTERVAL){
                step();
                last = now;
            }
        }
    }

    @FXML
    public void initialize() {
        clock = new Movement();
//        world.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
    }

    @FXML
    public void reset() {
        stop();
        world.getChildren().clear();
        sim = new Simulation(world, 100);
    }

    @FXML
    public void start() {
        clock.start();
        disableButtons(true, false, true);
    }
    @FXML
    public void stop() {
        clock.stop();
        disableButtons(false, true, false);
    }
    @FXML
    public void step() {
        sim.move();
        sim.getStatus();
        sim.goInfecting();
        sim.feelBetter();
        sim.resolveCollisions(); //Вызов функции заражения
        sim.draw();
//        sim.drawOutOfBoundary();

    }

    public void disableButtons(boolean start, boolean stop, boolean step) {
        startButton.setDisable(start);
        stopButton.setDisable(stop);
        stepButton.setDisable(step);
    }
}
