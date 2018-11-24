package com.github.suhininalex.tetris.gui;

import com.github.suhininalex.tetris.core.Playground;
import com.github.suhininalex.tetris.gui.CanvasPanel;

import javax.swing.*;

public class GamePanel {

    private final Playground gamefield;

    public JButton restartButton;
    public JPanel playground;
    public JPanel panel;

    public GamePanel(Playground gamefield) {
        this.gamefield = gamefield;
    }

    private void createUIComponents() {
        playground = new CanvasPanel(gamefield);
    }
}
