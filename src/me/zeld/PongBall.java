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
            getDirectionAndSpeed();
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void getDirectionAndSpeed(){
        XPOS += (int) (Math.sin(DIRECTION/(360 * Math.PI)) * SPEED);
        XPOS += (int) (Math.cos(DIRECTION/(360 * Math.PI)) * SPEED);
        setLocation(XPOS, YPOS);


/*        if(YPOS > 0){
            YPOS -= 10;
        }
        if(YPOS + SIZE < B.getSCREEN_HEIGHT()){
            YPOS += 10;
        }*/
    }
}