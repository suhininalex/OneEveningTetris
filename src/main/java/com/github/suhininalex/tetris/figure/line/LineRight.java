package com.github.suhininalex.tetris.figure.line;

import com.github.suhininalex.tetris.core.Figure;
import com.github.suhininalex.tetris.core.SquareModule;

import java.util.List;

public class LineRight implements Figure {

    public final double x;
    public final double y;

    public LineRight(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public List<SquareModule> getModules() {
        return List.of(new SquareModule(x-1, y-1), new SquareModule(x, y-1), new SquareModule(x+1, y-1), new SquareModule(x+2, y-1));
    }

    @Override
    public Figure move(double dx, double dy) {
        return new LineRight(x+dx, y+dy);
    }

    @Override
    public Figure turnLeft() {
        return new LineUp(x, y);
    }

    @Override
    public Figure turnRight() {
        return new LineUp(x, y);
    }

}
