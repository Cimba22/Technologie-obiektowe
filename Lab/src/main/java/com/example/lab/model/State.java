package com.example.lab.model;

import javafx.scene.paint.Color;

public enum State {
    SUSCEPTIBLE {
        @Override
        public Color getColor() {
            return Color.BLUE;
        }
    },

    INFECTED {
        @Override
        public Color getColor() {
            return Color.RED;
        }
    },

    RECOVERED {
        @Override
        public Color getColor() {
            return Color.GREEN;
        }
    };

    public abstract Color getColor();
}
