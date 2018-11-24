package com.github.suhininalex.tetris.figure.line;

import com.github.suhininalex.tetris.core.Figure;
import com.github.suhininalex.tetris.core.SquareModule;

import java.util.List;

public class LineUp implements Figure {

    public final double x;
    public final double y;

    public LineUp(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public List<SquareModule> getModules() {
        return List.of(new SquareModule(x, y), new SquareModule(x, y-1), new SquareModule(x, y-2), new SquareModule(x, y-3));
    }

    @Override
    public Figure move(double dx, double dy) {
        return new LineUp(x+dx, y+dy);
    }

    @Override
    public Figure turnLeft() {
        return new LineRight(x, y);
    }

    @Override
    public Figure turnRight() {
        return new LineRight(x, y);
    }
}
