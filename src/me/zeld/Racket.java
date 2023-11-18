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
    private final boolean OTHER_PLAYER;
    private final int SCREEN_HEIGHT;
    Racket(Board b, int xPos, int xSize, int ySize, boolean otherPlayer){
        B = b;
        SCREEN_HEIGHT = B.getSCREEN_HEIGHT();
        YSIZE = ySize;
        XSIZE = xSize;
        XPOS = xPos;
        YPOS = (SCREEN_HEIGHT / 2) - (YSIZE / 2);
        YPOS_SECOND_PLAYER = YPOS;
        XPOS_SECOND_PLAYER = B.getSCREEN_WIDTH() - XPOS - XSIZE;
        OTHER_PLAYER = otherPlayer;

        setBackground(new Color(0xC5C53A));
        addRackets();
    }

    Racket(Board b, int xPos, int xSize, int ySize){
        B = b;
        SCREEN_HEIGHT = B.getSCREEN_HEIGHT();
        YSIZE = ySize;
        XSIZE = xSize;
        XPOS = xPos;
        YPOS = (SCREEN_HEIGHT / 2) - (YSIZE / 2);
        YPOS_SECOND_PLAYER = YPOS;
        OTHER_PLAYER = false;

        setBackground(new Color(0xC5C53A));
        addRackets();
    }

    private void addRackets(){
        if(OTHER_PLAYER) {
            setLocation(XPOS_SECOND_PLAYER,YPOS_SECOND_PLAYER);
        }else{
            setLocation(XPOS, YPOS);
        }
        setSize(XSIZE,YSIZE);
        B.add(this);
    }
    private void moveUp(){
        YPOS -= 10;
        setLocation(XPOS,YPOS);
    }
    private void moveDown(){
        YPOS += 10;
        setLocation(XPOS,YPOS);
    }
    private void moveUpSecondPlayer(){
        YPOS_SECOND_PLAYER -= 10;
        setLocation(XPOS_SECOND_PLAYER,YPOS_SECOND_PLAYER);
    }
    private void moveDownSecondPlayer(){
        YPOS_SECOND_PLAYER += 10;
        setLocation(XPOS_SECOND_PLAYER,YPOS_SECOND_PLAYER);
    }

    private void moveOnlyUp(KeyEvent e){
        if(OTHER_PLAYER) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                moveUpSecondPlayer();
            }
        }else {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                moveUp();
            }
        }
    }
    private void moveOnlyDown(KeyEvent e){
        if(OTHER_PLAYER) {
            if (e.getKeyCode() == KeyEvent.VK_S) {
                moveDownSecondPlayer();
            }
        }else {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                moveDown();
            }
        }
    }
    private void moveGeneric(KeyEvent e){
        if(OTHER_PLAYER) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_W-> moveUpSecondPlayer();
                case KeyEvent.VK_S -> moveDownSecondPlayer();
            }
        }else {
            switch (e.getKeyCode()){
                case KeyEvent.VK_UP -> moveUp();
                case KeyEvent.VK_DOWN -> moveDown();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (!(YPOS == 0 || YPOS_SECOND_PLAYER == 0) && !(YPOS == SCREEN_HEIGHT - YSIZE || YPOS_SECOND_PLAYER == SCREEN_HEIGHT - YSIZE ) ) {
            moveGeneric(e);
        }else if (YPOS == 0 || YPOS_SECOND_PLAYER == 0 ){
            moveOnlyDown(e);
        }else if (YPOS == SCREEN_HEIGHT - YSIZE || YPOS_SECOND_PLAYER == SCREEN_HEIGHT - YSIZE){
            moveOnlyUp(e);
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
