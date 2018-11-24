package com.github.suhininalex.tetris.gui;

import com.github.suhininalex.tetris.core.Playground;

import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel {

    private Playground playground;

    public CanvasPanel(Playground playground){
        super();
        this.playground = playground;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var graphics = new SizedGraphics((Graphics2D) g, getWidth(), getHeight());
        var canvas = new Canvas(graphics, playground.width, playground.height);
        var painter = new Painter(canvas);
        painter.drawFigure(playground.figure);
        playground.getModules().forEach(painter::drawModule);
    }

}
