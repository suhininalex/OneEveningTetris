package com.github.suhininalex.tetris.core;

import java.util.List;

public interface Figure {

    List<SquareModule> getModules();

    Figure move(double dx, double dy);
    Figure turnLeft();
    Figure turnRight();
}
