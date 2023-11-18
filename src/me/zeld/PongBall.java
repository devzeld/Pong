package me.zeld;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class PongBall extends JPanel {
    private int XPOS;
    private int YPOS;
    private final int SIZE;
    private final int SPEED = 10;
    private final int BALL_SPEED = 5;
    private final int DIRECTION = 180;
    private final Board B;

    PongBall(Board b, int size) {
        B = b;
        SIZE = size;
        Color COLOR = new Color(0x000020);

        setBackground(COLOR);
        setToCenter();
        setBounds(XPOS,YPOS, SIZE, SIZE);
        b.add(this);

    }

    private void setToCenter(){
        XPOS = (B.getSCREEN_WIDTH() / 2) - SIZE;
        YPOS = (B.getSCREEN_HEIGHT() / 2) - SIZE;
    }

    public void startMoving(){
        while(true){
            getDirectionAndSpeed(B.checkCollision());
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void getDirectionAndSpeed(boolean rebound){
        final double cos = Math.cos(DIRECTION / (360 * Math.PI)) * SPEED;
        final double sin = Math.sin(DIRECTION / (360 * Math.PI)) * SPEED;



        XPOS += rebound ? (int) sin + (int) cos : -((int) sin + (int) cos);
        setLocation(XPOS, YPOS);




        /*YPOS += (int) sin;
        YPOS += (int) cos;*/
    }
}