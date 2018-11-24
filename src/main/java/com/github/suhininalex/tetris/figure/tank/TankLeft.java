package com.github.suhininalex.tetris.figure.tank;

import com.github.suhininalex.tetris.core.Figure;
import com.github.suhininalex.tetris.core.SquareModule;

import java.util.List;

public class TankLeft implements Figure {

    public final double x;
    public final double y;

    public TankLeft(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public List<SquareModule> getModules() {
        return List.of(new SquareModule(x, y-1), new SquareModule(x+1, y-1), new SquareModule(x+1, y), new SquareModule(x+1, y-2));
    }

    @Override
    public Figure move(double dx, double dy) {
        return new TankLeft(x+dx, y+dy);
    }

    @Override
    public Figure turnLeft() {
        return new TankDown(x,y);
    }

    @Override
    public Figure turnRight() {
        return new TankUp(x,y);
    }
}
