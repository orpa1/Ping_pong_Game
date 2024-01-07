package com.mycompany.mavenproject2;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {
        initComponents();
        setSize(1015, 640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Ping-Pong Game");
        setVisible(true);
        GamePanel panel = new GamePanel();
        add(panel);

    }

    public void initComponents() {

        this.setIconImage(PlayersInfo.icon.getImage());
    }

}
