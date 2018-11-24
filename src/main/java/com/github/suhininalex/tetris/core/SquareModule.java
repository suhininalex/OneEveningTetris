package com.github.suhininalex.tetris.core;

public class SquareModule {
    public final double x;
    public final double y;

    public SquareModule(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "SquareModule(x="+x+", y="+y+")";
    }
}
