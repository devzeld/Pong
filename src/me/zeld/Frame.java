package me.zeld;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    Frame(){
        setTitle("Pong");
        setUndecorated(true);
        setResizable(false);
        setSize(480, 300);
        setVisible(true);
        setLocation(500,500);
        setBackground(new Color(1f,1f,1f,.1f ));
    }
}
