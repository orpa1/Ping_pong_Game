package com.mycompany.mavenproject2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PlayersInfo extends JFrame {

    private JLabel messageLabel, player1Label, player2Label, imgLabel;
    private JTextField player1Field, player2Field;
    private JButton submitButton, clearButton;
    public static String player1Name, player2Name;
    private Container c;
    private Font f;
    public static ImageIcon icon, img;

    public PlayersInfo() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(910, 490);
        this.setLocationRelativeTo(null);
        this.setTitle("Ping-Pong Game");
        icon = new ImageIcon(getClass().getResource("img.png"));
        img = new ImageIcon(getClass().getResource("img2.png"));
        this.setIconImage(icon.getImage());
        this.setVisible(true);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(25, 118, 211));

        f = new Font("Consolas", Font.BOLD, 25);

        imgLabel = new JLabel(img);
        imgLabel.setBounds(450, 0, 445, 453);
        c.add(imgLabel);

        messageLabel = new JLabel("Welcome to Ping-Pong Game!");
        messageLabel.setBounds(35, 35, 400, 30);
        messageLabel.setFont(f);
        messageLabel.setForeground(Color.WHITE);
        c.add(messageLabel);

        f = f.deriveFont(20f);

        player1Label = new JLabel("Player 1 Name:");
        player1Label.setBounds(25, 110, 175, 25);
        player1Label.setFont(f);
        player1Label.setForeground(Color.WHITE);

        c.add(player1Label);

        player2Label = new JLabel("Player 2 Name:");
        player2Label.setBounds(25, 160, 175, 25);
        player2Label.setFont(f);
        player2Label.setForeground(Color.WHITE);
        c.add(player2Label);

        player1Field = new JTextField();
        player1Field.setBounds(200, 110, 200, 30);
        player1Field.setFont(f);
        player1Field.setForeground(new Color(25, 118, 211));
        player1Field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    player2Field.requestFocus();
                }
            }
        });
        c.add(player1Field);

        player2Field = new JTextField();
        player2Field.setBounds(200, 160, 200, 30);
        player2Field.setFont(f);
        player2Field.setForeground(new Color(25, 118, 211));
        player2Field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submitButton.doClick();
                }
            }
        });
        c.add(player2Field);

        player2Field.requestFocus();

        submitButton = new JButton("Submit");
        submitButton.setBounds(25, 330, 200, 40);
        submitButton.setFont(f);
        submitButton.setBackground(Color.WHITE);
        submitButton.setForeground(new Color(25, 118, 211));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                player1Name = player1Field.getText();
                player2Name = player2Field.getText();

                if (!player1Name.isEmpty() && !player2Name.isEmpty()) {

                    dispose();
                    GameFrame frame = new GameFrame();
                    System.out.println("Player 1: " + player1Name);
                    System.out.println("Player 2: " + player2Name);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter names for both players.", "Input Error",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        c.add(submitButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(225, 330, 200, 40);
        clearButton.setFont(f);
        clearButton.setBackground(Color.WHITE);
        clearButton.setForeground(new Color(25, 118, 211));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player1Field.setText("");
                player2Field.setText("");
            }
        });
        c.add(clearButton);

        submitButton.requestFocus();
        clearButton.requestFocus();
        player1Field.requestFocus();
    }

}
