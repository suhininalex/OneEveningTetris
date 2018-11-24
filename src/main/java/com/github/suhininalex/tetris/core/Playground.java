package com.github.suhininalex.tetris.core;

import com.github.suhininalex.tetris.figure.FigureBuilder;
import com.github.suhininalex.tetris.figure.line.LineRight;
import com.github.suhininalex.tetris.figure.line.LineUp;
import com.github.suhininalex.tetris.figure.tank.TankUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Playground {

    public final double width = 9;
    public final double height = 15;
    private final FigureBuilder figureBuilder = new FigureBuilder();

    private List<SquareModule> squares = new ArrayList<>();
    public Figure figure = figureBuilder.createRandom();

    private boolean isFast;

    public List<SquareModule> getModules() {
        return Collections.unmodifiableList(squares);
    }

    public void step(){
        var delta = isFast ? 0.15 : 0.05;
        figure = figure.move(0, -delta);
        if (! checkIsValid(figure)) {
            squares.addAll(figure.getModules().stream().map(module -> new SquareModule(Math.round(module.x), Math.round(module.y))).collect(toList()));
            figure = figureBuilder.createRandom();
            checkLines();
        }
    }

    public void speedUp(boolean isFast){
        this.isFast = isFast;
    }

    public void rotateLeft(){
        var rotated = figure.turnLeft();
        figure = checkIsValid(rotated) ? rotated : figure;
    }

    public void rotateRight(){
        var rotated = figure.turnRight();
        figure = checkIsValid(rotated) ? rotated : figure;
    }

    public void moveLeft(){
        var moved = figure.move(-1, 0);
        figure = checkIsValid(moved) ? moved : figure;
    }

    public void moveRight(){
        var moved = figure.move(+1, 0);
        figure = checkIsValid(moved) ? moved : figure;
    }

    private boolean intersects(SquareModule first, SquareModule second){
        return first.x == second.x && first.y - second.y < 1;
    }

    private boolean checkIsValid(SquareModule module){
        return module.x >= 0 && module.x <= width-1 && module.y - 1 >= 0 && squares.stream().noneMatch(fieldModule -> intersects(module, fieldModule));
    }

    private boolean checkIsValid(Figure figure){
        return figure.getModules().stream().allMatch(this::checkIsValid);
    }

    private void removeLine(int y){
        squares = squares.stream().filter(module -> (int)module.y != y).collect(toList());
        squares = squares.stream().map(module -> module.y >= y ? new SquareModule(module.x, module.y-1) : module).collect(toList());
    }

    private void checkLines(){
        var lines = squares.stream().collect(groupingBy(module -> module.y)).values();
        var fullLines = lines.stream().filter(line -> line.size() == 9).map(line -> (int) line.get(0).y);
        fullLines.forEach(this::removeLine);
    }
}
