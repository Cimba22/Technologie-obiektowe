package com.example.lab.model;

import javafx.scene.paint.Color;

public enum State {
    SUSCEPTIBLE {
        @Override
        public Color getColor() {
            return Color.BLUE;
        }
    },

    HAVE_SYMPTOMS {
        @Override
        public Color getColor() {
            return Color.GRAY;
        }
    },

    HAVE_NO_SYMPTOMS {
        @Override
        public Color getColor() {
            return Color.FIREBRICK;
        }
    },

    INFECTED {
        @Override
        public Color getColor() {
            return Color.RED;
        }
    },

    IMMUNE {
        @Override
        public Color getColor() {
            return Color.GOLD;
        }
    },

    RECOVERED {
        @Override
        public Color getColor() {
            return Color.GREEN;
        }
    };

    public abstract Color getColor();
//    public abstract Probability getProbability();
}
