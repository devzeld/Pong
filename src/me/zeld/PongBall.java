package me.zeld;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class PongBall extends JPanel {
    public int XPOS;
    public int YPOS;
    private final Board B;
    public final Color COLOR;
    PongBall(Board b, int xPos, int yPos, int size) {
        XPOS = xPos;
        YPOS = yPos;
        COLOR = new Color(0x000020);
        B = b;

        setBackground(COLOR);
        setBounds(XPOS,YPOS, size, size);
        b.add(this);
    }
}
