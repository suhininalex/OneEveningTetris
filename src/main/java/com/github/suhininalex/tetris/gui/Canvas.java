package com.github.suhininalex.tetris.gui;


public class Canvas {
    private final SizedGraphics graphics;

    private final double widthRatio;
    private final double heightRatio;

    public Canvas(SizedGraphics graphics, double width, double height) {
        this.graphics = graphics;
        widthRatio = graphics.width/width;
        heightRatio = graphics.height/height;
    }

    public void drawSquare(double x, double y, double size) {
        var canvas_x = toPixelX(x);
        var canvas_y = toPixelY(y);
        var canvas_width = (int) (size*widthRatio);
        var canvas_height = (int) (size*heightRatio);
        graphics.canvas.fillRect(canvas_x, canvas_y, canvas_width, canvas_height);
    }

    private int toPixelX(double x){
        return (int) (x*widthRatio);
    }

    private int toPixelY(double y){
        return graphics.height - (int) (y*heightRatio);
    }
}
