package me.zeld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JFrame{
    public final int SCREEN_HEIGHT = 300;
    public final int SCREEN_WIDTH = 480;
    private Image image;
    private Graphics graphics;
    private final PongBall pong = new PongBall(SCREEN_WIDTH / 2,SCREEN_HEIGHT / 2 - 20,Color.BLACK,20);
    private final Racket rackets = new Racket(this, 20,100, Color.LIGHT_GRAY, 80, false);
    Board(){
        setTitle("Pong");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setUndecorated(true);
        setResizable(false);
        setSize(480, 300);
        setVisible(true);
        setLocation(SCREEN_WIDTH, SCREEN_HEIGHT);
        setBackground(new Color(1f,1f,1f,.5f ));

        addKeyListener(new RacketsMovements());

        for (int i = 0; i < 5; i++) {
            add(getMidScreenPanels());
        }

    }

    public JPanel getMidScreenPanels(){
        JPanel jp = new JPanel();
        jp.setBackground(Color.LIGHT_GRAY);
        jp.setLocation(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);
        jp.setSize(20, SCREEN_HEIGHT / 5 - 10);

        return jp;
    }
    public void paint(Graphics g){
        image = createImage(this.getWidth(), this.getHeight());
        graphics = image.getGraphics();
        g.drawImage(image, 0, 0, this);

        rackets.draw(g);
        pong.draw(g);
    }
    public void checkCollision() {
        if(pong.intersects(rackets)){
            rackets.draw(graphics);
        }

    }

    public class RacketsMovements extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            rackets.keyPressed(e);
            checkCollision();
            repaint();
        }
    }
}
