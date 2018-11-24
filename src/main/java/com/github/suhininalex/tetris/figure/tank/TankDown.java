package com.github.suhininalex.tetris.figure.tank;

import com.github.suhininalex.tetris.core.Figure;
import com.github.suhininalex.tetris.core.SquareModule;

import java.util.List;

public class TankDown implements Figure {

    public final double x;
    public final double y;

    public TankDown(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public List<SquareModule> getModules() {
        return List.of(new SquareModule(x, y), new SquareModule(x+1, y), new SquareModule(x+1, y-1), new SquareModule(x+2, y));
    }

    @Override
    public Figure move(double dx, double dy) {
        return new TankDown(x+dx, y+dy);
    }

    @Override
    public Figure turnLeft() {
        return new TankRight(x,y);
    }

    @Override
    public Figure turnRight() {
        return new TankLeft(x,y);
    }
}
