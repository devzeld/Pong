package me.zeld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongBall extends JPanel {
    private final int size;
    private int sX = 0;
    private int sY = 0;
    private int sWidth = 1;
    private int sHeight = 1;
    private final int initialBounds = 50;

    PongBall(int size) {
        this.size = size;
        setBackground(Color.BLACK);
        setBounds(initialBounds, initialBounds, this.size, this.size);
        setVisible(true);
    }
}
