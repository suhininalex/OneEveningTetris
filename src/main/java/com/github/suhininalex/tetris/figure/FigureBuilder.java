package com.github.suhininalex.tetris.figure;

import com.github.suhininalex.tetris.core.Figure;
import com.github.suhininalex.tetris.figure.line.LineUp;
import com.github.suhininalex.tetris.figure.tank.TankUp;

import java.util.List;
import java.util.Random;

public class FigureBuilder {

    private double startX = 4;
    private double startY = 17;
    private Random random = new Random();

    private List<Figure> available = List.of(
            new TankUp(startX, startY),
            new LineUp(startX, startY),
            new Hell(startX, startY),
            new Square(startX, startY)
    );

    public Figure createRandom(){
        var randomIndex = random.nextInt(available.size());
        var rotations = random.nextInt(4);
        var element = available.get(randomIndex);
        for (int i=0; i<=rotations; i++){
            element = element.turnRight();
        }
        return element;
    }
}
