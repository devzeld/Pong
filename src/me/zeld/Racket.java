package me.zeld;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Racket extends Rectangle implements KeyListener {
    public final Color COLOR;
    public int XPOS;
    public int YPOS;
    public final int SIZE;
    private final boolean SINGLE_PLAYER;
    private final int SCREEN_WIDTH;
    Racket(Board b, int xPos, int yPos, Color color, int size, boolean singlePlayer){
        COLOR = color;
        XPOS = xPos;
        YPOS = yPos;
        SIZE = size;
        SCREEN_WIDTH = b.SCREEN_WIDTH;
        SINGLE_PLAYER = singlePlayer;


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(SINGLE_PLAYER) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                YPOS -= 15;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                YPOS += 15;
            }
        }else {
            if(e.getKeyCode() == KeyEvent.VK_UP){
                YPOS -= 15;
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                YPOS += 15;
            }
            if(e.getKeyCode() == KeyEvent.VK_W){
                YPOS -= 15;
            }
            if(e.getKeyCode() == KeyEvent.VK_S) {
                YPOS += 15;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void draw(Graphics g){
        if(SINGLE_PLAYER) {
            g.setColor(COLOR);
            g.fillRect(XPOS,YPOS,10,SIZE);
        }else{
            g.setColor(COLOR);
            g.fillRect(XPOS,YPOS,10,SIZE);

            g.setColor(COLOR);
            g.fillRect(SCREEN_WIDTH - XPOS - 10,YPOS,10,SIZE);
        }
    }
}
