package me.zeld;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class PongBall extends JPanel {
    private int XPOS;
    private int YPOS;
    private final int SIZE;
    private final int BALL_SPEED = 7;
    private final int DIRECTION = 30;
    private int directionX= (int) (Math.cos(DIRECTION * (360 / Math.TAU)) * BALL_SPEED);
    private int directionY= (int) (Math.sin(DIRECTION * (360 / Math.TAU)) * BALL_SPEED);
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

        directionX = (int) (Math.cos(DIRECTION * (360 / Math.TAU)) * BALL_SPEED);
        directionY = (int) (Math.sin(DIRECTION * (360 / Math.TAU)) * BALL_SPEED);
    }

    //need to update the position of the pong ball
    public void startBallMoving() {
        while (true) {
            updateDirection();
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //need set the direction and the speed of the ball
    //set the rebound for the direction too
    private void updateDirection() {

        /*
        //TODO: Future untouchable ability...
        if(checkCollisionWithRackets()){
            XPOS -= (int) (Math.cos(- DIRECTION * (360 / Math.TAU)) * BALL_SPEED);
            YPOS -= (int) (Math.sin(- DIRECTION * (360 / Math.TAU)) * BALL_SPEED);
            setLocation(XPOS, YPOS);
        }
        */


        if (B.getRacket1().getBounds().intersects(B.getPong().getBounds()) || B.getRacket2().getBounds().intersects(B.getPong().getBounds())){
            directionX = -(directionX);
        }

        if (!(YPOS > 0 && YPOS < B.getSCREEN_HEIGHT() - SIZE)){
            directionY = -(directionY);
        }

        if (!(XPOS > 0 && XPOS < B.getSCREEN_WIDTH() - SIZE)) {
            setToCenter();
        }

        XPOS += directionX;
        YPOS += directionY;

        setLocation(XPOS, YPOS);
    }
}