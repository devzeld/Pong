package me.zeld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JFrame{
    public final int SCREEN_HEIGHT = 500;
    public final int SCREEN_WIDTH = 630;
    private final PongBall pong = new PongBall(this,SCREEN_WIDTH / 2,SCREEN_HEIGHT / 2 - 20,20);
    private final Racket racket1 = new Racket(this, 20, 10, 100);
    private final Racket racket2 = new Racket(this, 20, 10, 100,true);
    Board(){
        setTitle("Pong");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        setLayout(null);
        setLocation(500, 100);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        addKeyListener(new RacketsMovements());
        setBackground(new Color(1f,1f,1f,.3f));

        setVisible(true);
        pack();
    }

    public void checkCollision() {
        Rectangle rec1Racket = racket1.getBounds();
        Rectangle rec2Racket = racket2.getBounds();
        Rectangle pongRacket = pong.getBounds();
        if(rec1Racket.intersects(pongRacket) || rec2Racket.intersects(pongRacket)) {
            System.out.println(true);
        }
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
