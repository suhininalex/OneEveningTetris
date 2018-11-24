package com.github.suhininalex.tetris.gui;

import java.awt.*;

public class SizedGraphics {
    public final int width;
    public final int height;
    public final Graphics2D canvas;

    public SizedGraphics(Graphics2D canvas, int width, int height) {
        this.width = width;
        this.height = height;
        this.canvas = canvas;
    }
}