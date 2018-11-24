package com.github.suhininalex.tetris.launcher;

import com.github.suhininalex.tetris.core.Playground;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class KeyboardProcessor implements KeyListener {

    private final Playground playground;

    KeyboardProcessor(Playground playground) {
        this.playground = playground;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            playground.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            playground.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            playground.rotateLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            playground.speedUp(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            playground.speedUp(false);
        }
    }
}