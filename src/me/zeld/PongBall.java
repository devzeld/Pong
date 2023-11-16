package me.zeld;

import java.awt.*;

public class PongBall extends Rectangle {
    private final int SIZE;
    public int XPOS;
    public int YPOS;
    public final Color COLOR;
    PongBall(int xPos, int yPos, Color color, int size) {
        this.SIZE = size;
        this.XPOS = xPos;
        this.YPOS = yPos;
        this.COLOR = color;
        setBounds(xPos, yPos, this.SIZE, this.SIZE);
    }

    public void draw(Graphics g){
        g.setColor(this.COLOR);
        g.fillRect(this.XPOS,this.YPOS,this.SIZE,this.SIZE);
    }
}
