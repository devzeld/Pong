package me.zeld;

import javax.swing.*;
import java.awt.*;

public class PongGame extends JFrame{
    public final int height = 300;
    public final int width = 480;
    PongGame(){
        setTitle("Pong");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(480, 300);
        setVisible(true);
        setLocation(width,height);
        setBackground(new Color(1f,1f,1f,.5f ));
        add(new PongBall(20));
    }
}
