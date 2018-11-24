package com.github.suhininalex.tetris.gui;

import com.github.suhininalex.tetris.core.Figure;
import com.github.suhininalex.tetris.core.SquareModule;

public class Painter {

    private final Canvas canvas;

    public Painter(Canvas canvas) {
        this.canvas = canvas;
    }

    public void drawFigure(Figure figure){
        figure.getModules().forEach((this::drawModule));
        for (var module : figure.getModules()){
            canvas.drawSquare(module.x+0.025, module.y+0.025, 0.95);
        }
    }

    public void drawModule(SquareModule module){
        canvas.drawSquare(module.x+0.025, module.y+0.025, 0.95);
    }
}
