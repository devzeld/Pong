package me.zeld;

import javax.swing.*;
import java.awt.*;

public class Racket extends JPanel {
    private int XPOS;
    private int YPOS;
    private final int YSIZE;
    private final int XSIZE;
    private final int RACKET_SPEED = 10;
    private final PongBoard B;

    public Racket(PongBoard b, boolean isHuman, boolean isLeft) {
        B = b;
        YSIZE = B.getSCREEN_HEIGHT() / 5;
        XSIZE = 15;
        XPOS = 10;

        setBackground(new Color(0x000020));
        addRackets(isLeft);
        B.add(this);
    }

    private void addRackets(boolean left) {
        YPOS = (B.getSCREEN_HEIGHT() / 2) - (YSIZE / 2);
        XPOS = left ? 10 : B.getSCREEN_WIDTH() - XSIZE - 10;

        setSize(XSIZE, YSIZE);
        setLocation(XPOS, YPOS);
    }

    public void moveRacket(boolean moveUp) {
        if (moveUp) {
            if (YPOS - 10 > 0) {
                YPOS -= RACKET_SPEED;
            }
        } else {
            if (YPOS + YSIZE + 10 < B.getSCREEN_HEIGHT()) {
                YPOS += RACKET_SPEED;
            }
        }
        setLocation(XPOS, YPOS);
    }
    public int getXPOS() {
        return XPOS;
    }

    public int getYPOS() {
        return YPOS;
    }

    public int getYSIZE() {
        return YSIZE;
    }

    public int getXSIZE() {
        return XSIZE;
    }

    public int getRACKET_SPEED() {
        return RACKET_SPEED;
    }
}