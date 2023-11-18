package me.zeld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JFrame{
    private final int SCREEN_HEIGHT;
    private final int SCREEN_WIDTH;
    private final PongBall pong;
    private final Racket racket1;
    private final Racket racket2;
    Board(int width, int height){
        SCREEN_HEIGHT = height;
        SCREEN_WIDTH = width;
        pong = new PongBall(this,20);
        racket1  = new Racket(this, 10, 10, SCREEN_HEIGHT / 5, true);
        racket2 = new Racket(this, 10, 10, SCREEN_HEIGHT / 5);

        setTitle("Pong");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        setLayout(null);
        setLocation(500, 100);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        addKeyListener(new RacketsMovements());
        setBackground(new Color(1f,1f,1f,.3f));
//        setOpacity(0.1f);

        setVisible(true);
        pack();
    }

    private void checkCollision() {
        Rectangle rec1Racket = racket1.getBounds();
        Rectangle rec2Racket = racket2.getBounds();
        Rectangle pongRacket = pong.getBounds();
        if(rec1Racket.intersects(pongRacket) || rec2Racket.intersects(pongRacket)) {
            System.out.println(true);
        }
    }

    public int getSCREEN_HEIGHT() {
        return SCREEN_HEIGHT;
    }

    public int getSCREEN_WIDTH() {
        return SCREEN_WIDTH;
    }

    public class RacketsMovements extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            racket1.keyPressed(e);
            racket2.keyPressed(e);
            checkCollision();
        }
    }
}
