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
    private int XPOS_SECOND_PLAYER = 0;
    private final Board B;
    private final boolean IS_PLAYER;
    Racket(Board b, int xPos, int xSize, int ySize, boolean isPlayer){
        B = b;
        YSIZE = ySize;
        XSIZE = xSize;
        XPOS = xPos;
        YPOS = (B.getSCREEN_HEIGHT() / 2) - (YSIZE / 2);
        YPOS_SECOND_PLAYER = YPOS;
        XPOS_SECOND_PLAYER = B.getSCREEN_WIDTH() - XPOS - XSIZE;
        IS_PLAYER = isPlayer;

        setBackground(new Color(0xC5C53A));
        addRackets();
    }

    private void addRackets(){
        if(IS_PLAYER) {
            setLocation(XPOS_SECOND_PLAYER,YPOS_SECOND_PLAYER);
        }else{
            setLocation(XPOS, YPOS);
        }
        setSize(XSIZE,YSIZE);
        B.add(this);
    }
    private void move(boolean isUp){
        YPOS += isUp ? -10 : 10;
        setLocation(XPOS,YPOS);
    }
    private void moveSecondPlayer(boolean isUp){
        YPOS_SECOND_PLAYER += isUp ? -10 : 10;
        setLocation(XPOS_SECOND_PLAYER,YPOS_SECOND_PLAYER);
    }


    private void moveOnlyUp(KeyEvent e){
        if(IS_PLAYER) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                moveSecondPlayer(true);
            }
        }else {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                move(true);
            }
        }
    }
    private void moveOnlyDown(KeyEvent e){
        if(IS_PLAYER) {
            if (e.getKeyCode() == KeyEvent.VK_S) {
                moveSecondPlayer(false);
            }
        }else {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                move(false);
            }
        }
    }
    private void moveGeneric(KeyEvent e){
        if(IS_PLAYER) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_W-> moveSecondPlayer(true);
                case KeyEvent.VK_S -> moveSecondPlayer(false);
            }
        }else {
            switch (e.getKeyCode()){
                case KeyEvent.VK_UP -> move(true);
                case KeyEvent.VK_DOWN -> move(false);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (!(YPOS == 0 || YPOS_SECOND_PLAYER == 0) && !(YPOS == B.getSCREEN_HEIGHT() - YSIZE || YPOS_SECOND_PLAYER == B.getSCREEN_HEIGHT() - YSIZE ) ) {
            moveGeneric(e);
        }else if (YPOS == 0 || YPOS_SECOND_PLAYER == 0 ){
            moveOnlyDown(e);
        }else if (YPOS == B.getSCREEN_HEIGHT() - YSIZE || YPOS_SECOND_PLAYER == B.getSCREEN_HEIGHT() - YSIZE){
            moveOnlyUp(e);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
