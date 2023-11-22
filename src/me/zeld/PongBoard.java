package me.zeld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PongBoard extends JFrame {
    private final int SCREEN_HEIGHT;
    private final int SCREEN_WIDTH;
    private final PongBall pong;
    private final Racket racket1;
    private final Racket racket2;

    public PongBoard(int width, int height) {
        SCREEN_HEIGHT = height;
        SCREEN_WIDTH = width;

        pong = new PongBall(this, 20);
        racket1 = new Racket(this, true, true);
        racket2 = new Racket(this, true, false);

        setTitle("Pong");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        setLayout(null);
        setLocation(500, 100);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        addKeyListener(new RacketsMovements());
        setBackground(new Color(1f, 1f, 1f, .3f));

        setVisible(true);
        pack();

        pong.startBallMoving();
    }
    enum DIFFICULTY {
        LOW,
        MEDIUM,
        HIGH;
    }
    public int getSCREEN_HEIGHT() {
        return SCREEN_HEIGHT;
    }
    public int getSCREEN_WIDTH() {
        return SCREEN_WIDTH;
    }

    public PongBall getPong() {
        return pong;
    }
    public Racket getRacket1() {
        return racket1;
    }
    public Racket getRacket2() {
        return racket2;
    }
    public class RacketsMovements extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP -> racket2.moveRacket(true);
                case KeyEvent.VK_DOWN -> racket2.moveRacket(false);
                case KeyEvent.VK_W -> racket1.moveRacket(true);
                case KeyEvent.VK_S -> racket1.moveRacket(false);
                case KeyEvent.VK_ESCAPE -> System.exit(69);
            }
        }
    }
}