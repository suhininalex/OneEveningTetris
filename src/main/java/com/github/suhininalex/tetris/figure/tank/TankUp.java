package com.github.suhininalex.tetris.figure.tank;

import com.github.suhininalex.tetris.core.Figure;
import com.github.suhininalex.tetris.core.SquareModule;

import java.util.List;

public class TankUp implements Figure {

    public final double x;
    public final double y;

    public TankUp(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public List<SquareModule> getModules() {
        return List.of(new SquareModule(x, y-1), new SquareModule(x+1, y-1), new SquareModule(x+1, y), new SquareModule(x+2, y-1));
    }

    @Override
    public Figure move(double dx, double dy) {
        return new TankUp(x+dx, y+dy);
    }

    @Override
    public Figure turnLeft() {
        return new TankLeft(x,y);
    }

    @Override
    public Figure turnRight() {
        return new TankRight(x, y);
    }
}