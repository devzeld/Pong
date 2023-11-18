package me.zeld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Racket extends JPanel implements KeyListener {
    private final int XPOS;
    private int YPOS;
    private final int YSIZE;
    private final int XSIZE;
    private int YPOS_SECOND_PLAYER;
    private final int XPOS_SECOND_PLAYER;
    private final Board B;
    private final boolean IS_OTHER_PLAYER;
    Racket(Board b, int xPos, boolean thereIsAntherPlayer){
        B = b;
        YSIZE = B.getSCREEN_HEIGHT() / 5;
        XSIZE = 15;
        XPOS = xPos;
        YPOS = (B.getSCREEN_HEIGHT() / 2) - (YSIZE / 2);
        YPOS_SECOND_PLAYER = YPOS;
        XPOS_SECOND_PLAYER = B.getSCREEN_WIDTH() - XPOS - XSIZE;
        IS_OTHER_PLAYER = thereIsAntherPlayer;

        setBackground(new Color(0xC5C53A));
        addRackets();
    }

    private void addRackets(){
        if(IS_OTHER_PLAYER) {
            setLocation(XPOS, YPOS);
        }else{
            setLocation(XPOS_SECOND_PLAYER,YPOS_SECOND_PLAYER);
        }
        setSize(XSIZE,YSIZE);
        B.add(this);
    }
    private void moveFirstPlayer(boolean isUp){
        if(isUp){
            if(YPOS > 0){
                YPOS -= 10;
            }
        }else{
            if(YPOS + YSIZE < B.getSCREEN_HEIGHT()){
                YPOS += 10;
            }
        }
        setLocation(XPOS, YPOS);
    }
    private void moveSecondPlayer(boolean isUp){
        if(isUp){
            if(YPOS_SECOND_PLAYER > 0){
                YPOS_SECOND_PLAYER -= 10;
            }
        }else{
            if(YPOS_SECOND_PLAYER + YSIZE < B.getSCREEN_HEIGHT()){
                YPOS_SECOND_PLAYER += 10;
            }
        }
        setLocation(XPOS_SECOND_PLAYER,YPOS_SECOND_PLAYER);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(IS_OTHER_PLAYER) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_UP -> moveFirstPlayer(true);
                case KeyEvent.VK_DOWN -> moveFirstPlayer(false);
            }
        }else{
            switch(e.getKeyCode()) {
                case KeyEvent.VK_W -> moveSecondPlayer(true);
                case KeyEvent.VK_S -> moveSecondPlayer(false);
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}