package me.zeld;

import javax.swing.*;
import java.awt.*;

public class PongBall extends JPanel {
    public int XPOS;
    public int YPOS;
    public final Color COLOR;
    PongBall(Board b, int xPos, int yPos, int size) {
        XPOS = xPos;
        YPOS = yPos;
        COLOR = new Color(0x000020);

        setBackground(COLOR);
        setBounds(XPOS,YPOS, size, size);
        b.add(this);
    }
}
