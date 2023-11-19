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

    private void setToCenter() {
        XPOS = (B.getSCREEN_WIDTH() / 2) - SIZE;
        YPOS = (B.getSCREEN_HEIGHT() / 2) - SIZE;
    }

    public void startMoving() {
        while (true) {
            getDirectionAndSpeed(B.checkCollisionWithRackets(), false);
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void getDirectionAndSpeed(boolean racketRebound, boolean screenRebound) {
        final int cos = (int) (Math.cos(DIRECTION / (360 * Math.PI)) * BALL_SPEED);
        final int sin = (int) (Math.sin(DIRECTION / (360 * Math.PI)) * BALL_SPEED);



        setLocation(XPOS, YPOS);

        /*YPOS += (int) sin;
        YPOS += (int) cos;*/
    }
}