package me.zeld;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PongBall extends JPanel {
    private int XPOS;
    private int YPOS;
    private final int SIZE;
    private double BALL_SPEED = 8;
    private int directionX;
    private int directionY;
    private int POINTS_FIRST_PLAYER = 0;
    private int POINTS_SECOND_PLAYER = 0;
    private final PongBoard B;

    public PongBall(PongBoard b, int size) {
        B = b;
        SIZE = size;
        Color COLOR = new Color(0x19B287);

        setBackground(COLOR);
        setToCenter(true);
        setBounds(XPOS, YPOS, SIZE, SIZE);
        b.add(this);
    }

    private void setToCenter(boolean turnLeft) {
        XPOS = (B.getSCREEN_WIDTH() / 2) - SIZE;
        YPOS = (B.getSCREEN_HEIGHT() / 2) - SIZE;

        randomizeBall(turnLeft);

        System.out.printf("| 1: %s | 2: %s |", POINTS_FIRST_PLAYER, POINTS_SECOND_PLAYER);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("\r");
    }

    public void randomizeBall(boolean turnLeft){
        Random r = new Random();
        int randXDirection = turnLeft ? r.nextInt(30, 90) : r.nextInt(180, 240);
        int randYDirection = turnLeft ? r.nextInt(130, 170) : r.nextInt(10, 80);

        directionX = (int) (Math.cos(randXDirection * (360 / Math.TAU)) * BALL_SPEED);
        directionY = (int) (Math.sin(randYDirection * (360 / Math.TAU)) * BALL_SPEED);
    }

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

    private void updateDirection() {
        /*
        //TODO: Future untouchable ability...
        if(checkCollisionWithRackets()){
            XPOS -= (int) (Math.cos(- DIRECTION * (360 / Math.TAU)) * BALL_SPEED);
            YPOS -= (int) (Math.sin(- DIRECTION * (360 / Math.TAU)) * BALL_SPEED);
            setLocation(XPOS, YPOS);
        }
        */

        if (B.getRacket1().getBounds().intersects(B.getPong().getBounds()) || B.getRacket2().getBounds().intersects(B.getPong().getBounds())) {
            directionX = -(directionX);
            BALL_SPEED += 0.02;
        }
        if (!(YPOS >= 0 && YPOS <= B.getSCREEN_HEIGHT() - SIZE)){
            directionY = -(directionY);
            BALL_SPEED += 0.05;
        }
        if (!(XPOS >= 0 && XPOS <= B.getSCREEN_WIDTH() - SIZE)) {
            if (!(XPOS >= 0)) {
                POINTS_SECOND_PLAYER += 1;
                setToCenter(true);
            }
            if (!(XPOS <= B.getSCREEN_WIDTH() - SIZE)) {
                POINTS_FIRST_PLAYER += 1;
                setToCenter(false);
            }
        }

        XPOS += directionX;
        YPOS += directionY;
        setLocation(XPOS, YPOS);
    }

    public int getPOINTS_FIRST_PLAYER() {
        return POINTS_FIRST_PLAYER;
    }

    public int getPOINTS_SECOND_PLAYER() {
        return POINTS_SECOND_PLAYER;
    }
}