package com.github.suhininalex.tetris.figure;

import com.github.suhininalex.tetris.core.Figure;
import com.github.suhininalex.tetris.core.SquareModule;

import java.util.List;

public class Square implements Figure {

    private final double x;
    private final double y;

    public Square(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public List<SquareModule> getModules() {
        return List.of(new SquareModule(x,y), new SquareModule(x+1,y), new SquareModule(x,y-1), new SquareModule(x+1,y-1));
    }

    @Override
    public Figure move(double dx, double dy) {
        return new Square(x+dx, y+dy);
    }

    @Override
    public Figure turnLeft() {
        return this;
    }

    @Override
    public Figure turnRight() {
        return this;
    }
}
