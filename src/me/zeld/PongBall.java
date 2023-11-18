package me.zeld;

import javax.swing.*;
import java.awt.*;

public class PongBall extends JPanel {
    private int XPOS;
    private int YPOS;
    private final int SIZE;
    private final int BALL_SPEED = 5;
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

    private void startMoving(){

    }


}
