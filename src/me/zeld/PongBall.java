package me.zeld;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class PongBall extends JPanel {
    private int XPOS;
    private int YPOS;
    private final int SIZE;
    private final int BALL_SPEED = 7;
    private final int DIRECTION = 180;
    private int POINTS_FIRST_PLAYER;
    private int POINTS_SECOND_PLAYER;
    private final PongBoard B;

    PongBall(PongBoard b, int size) {
        B = b;
        SIZE = size;
        Color COLOR = new Color(0x000020);

        setBackground(COLOR);
        setToCenter();
        setBounds(XPOS, YPOS, SIZE, SIZE);
        b.add(this);

    }

    //need to set centered the pong ball
    private void setToCenter() {
        XPOS = (B.getSCREEN_WIDTH() / 2) - SIZE;
        YPOS = (B.getSCREEN_HEIGHT() / 2) - SIZE;
    }

    //need to update the position of the pong ball
    public void startBallMoving() {
        while (true) {
            getDirectionAndSpeed(B.checkCollisionWithRackets(), false);
            if (!(XPOS + SIZE > 0 && XPOS < B.getSCREEN_WIDTH() - SIZE)) {
                setToCenter();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //need set the direction and the speed of the ball
    //set the rebound for the direction too
    private void getDirectionAndSpeed(boolean racketRebound, boolean screenRebound) {
        final int cos = (int) (Math.cos(DIRECTION / (360 * Math.PI)) * BALL_SPEED);
        final int sin = (int) (Math.sin(DIRECTION / (360 * Math.PI)) * BALL_SPEED);
        final int reversedSin = (int) (Math.sin(-DIRECTION / (360 * Math.PI)) * BALL_SPEED);
        final int reversedCos = (int) (Math.cos(-DIRECTION / (360 * Math.PI)) * BALL_SPEED);

        XPOS += cos + sin;

        setLocation(XPOS, YPOS);


        if (!(XPOS + SIZE > 0 && XPOS < B.getSCREEN_WIDTH() - SIZE)) {
            setToCenter();
        }

        /*
        YPOS += (int) sin;
        YPOS += (int) cos;
        */
    }
}