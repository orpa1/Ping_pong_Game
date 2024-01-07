package com.mycompany.mavenproject2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements KeyListener {
    int ballX = 500 - 10, ballY = 300 - 10, ballWidth = 20, ballHeight = 20;
    int paddle1X = 2, paddle1Y = 250, paddleWidth = 20, paddleHeight = 100;
    int paddle2X = 978, paddle2Y = 250; // Starting position for the second paddle
    int ballSpeedX = 11, ballSpeedY = 11;
    int paddleSpeed = 20;
    int player1Score = 0, player2Score = 0;
    int maxScore = 2;
    boolean gameOver = false;
    



    GamePanel() {
        this.setBackground(Color.BLACK);
        this.setBounds(0, 0, 1000, 600);
        this.addKeyListener(this);
        this.setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
       
        super.paint(g);
     if (gameOver) {
        // Draw the winner message when the game is over
       
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.PLAIN, 50));
        if (player1Score == maxScore) {
            g.drawString("Game Over! "+PlayersInfo.player1Name+" wins!", 170, 270);
        } else if (player2Score == maxScore) {
            g.drawString("Game Over! "+PlayersInfo.player2Name+" wins!", 170, 270);
        }
   
     
     } else {
        // Draw paddles
        g.setColor(Color.RED);
        g.fillRect(paddle1X, paddle1Y, paddleWidth, paddleHeight);
        g.fillRect(paddle2X, paddle2Y, paddleWidth, paddleHeight);

        // Draw ball
        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, ballWidth, ballHeight);

        // Draw scores
        g.drawLine(1000/2, 0, 1000/2, 600);
        
        g.setFont(new Font("Consolas",Font.PLAIN,30));
        g.drawString(PlayersInfo.player1Name +": " + player1Score, 150, 30);
        g.drawString(PlayersInfo.player2Name+": " + player2Score, 650, 30);

        // Move ball
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Check for collisions with walls
        if (ballX <= 0 || ballX >= 1000 - ballWidth) {
            ballSpeedX = -ballSpeedX;
        }

        if (ballY <= 0 || ballY >= 600 - ballHeight) {
            ballSpeedY = -ballSpeedY;
        }

        // Check for collisions with paddles
        if (ballX <= paddle1X + paddleWidth && ballY >= paddle1Y && ballY <= paddle1Y + paddleHeight) {
            ballSpeedX = -ballSpeedX;
        }

        if (ballX + ballWidth >= paddle2X && ballY >= paddle2Y && ballY <= paddle2Y + paddleHeight) {
            ballSpeedX = -ballSpeedX;
        }

        
        // Check for scoring
    if (ballX <= 0) {
    player2Score++;
   
        reset();
    }
 else if (ballX >= 1000 - ballWidth) {
    player1Score++;
    
        reset();
    }

  if (player1Score >= maxScore||player2Score >= maxScore) {
           gameOver = true;
        }

        
        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();}
   
}
     
 
    private void reset() {
        paddle1Y = 250;
        paddle2Y = 250;
        
        ballX = 500 - ballWidth/2;
        ballY = 300 - ballHeight/2;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Move paddles based on key events
        if (e.getKeyCode() == KeyEvent.VK_UP && paddle2Y > 0) {
            paddle2Y -= paddleSpeed;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && paddle2Y < 600 - paddleHeight) {
            paddle2Y += paddleSpeed;
        }

        if (e.getKeyCode() == KeyEvent.VK_W && paddle1Y > 0) {
            paddle1Y -= paddleSpeed;
        } else if (e.getKeyCode() == KeyEvent.VK_S && paddle1Y < 600 - paddleHeight) {
            paddle1Y += paddleSpeed;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }
    
    
}
