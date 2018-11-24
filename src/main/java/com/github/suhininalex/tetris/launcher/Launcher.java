package com.github.suhininalex.tetris.launcher;

import com.github.suhininalex.tetris.core.Playground;
import com.github.suhininalex.tetris.core.Updater;
import com.github.suhininalex.tetris.gui.GamePanel;

import javax.swing.*;

public class Launcher {

    public static void main(String[] args){
        var playground = new Playground();
        var gamePanel = new GamePanel(playground);
        var updater = new Updater(playground, gamePanel.playground);
        gamePanel.restartButton.addKeyListener(new KeyboardProcessor(playground));
        var frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(gamePanel.panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        updater.start();
    }

}
