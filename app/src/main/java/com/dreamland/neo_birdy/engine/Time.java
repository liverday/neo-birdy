package com.dreamland.neo_birdy.engine;

public class Time {
    private double actual;
    public double getActual() {
        return this.actual;
    }

    public void increase() {
        this.actual += 0.05;
    }

    public void restart() {
        this.actual = 0;
    }
}
