package com.github.suhininalex.tetris.core;

import javax.swing.*;
import java.awt.*;

public class Updater {

    private Playground playground;
    private JComponent canvas;
    private Thread thread;

    public Updater(Playground playground, JComponent canvas) {
        this.playground = playground;
        this.canvas = canvas;
    }

    public void start(){
        thread = new Thread(()-> {
            try {
                while (true) {
                    playground.step();
                    EventQueue.invokeLater(() -> canvas.repaint());
                    Thread.sleep(20);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public void stop(){
        if (thread != null) {
            thread.interrupt();
            thread = null;
        }
    }

}