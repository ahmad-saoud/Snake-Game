package com.mycompany.snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.Duration;
import javax.swing.ImageIcon;

public class Game extends java.awt.Frame implements KeyListener {

    char dir = 's';
    Snake snake;
    Board board;
    boolean lose = false;
    Image headtop = new ImageIcon("headtop.png").getImage();
    Image headleft = new ImageIcon("headleft.png").getImage();
    Image headright = new ImageIcon("headright.png").getImage();
    Image headdown = new ImageIcon("headdown.png").getImage();
    Image head =  headdown ;
    Image body = new ImageIcon("body.png").getImage() ;
    public Game() {
        initComponents();
        this.addKeyListener(this);
        setSize(500, 700);
        snake = new Snake();
        board = new Board();
        board.width = this.getWidth();
        board.height = this.getHeight();
        board.generateFruite();

    }

    @Override
    public void paint(Graphics g) {
        this.setBackground(Color.green);
        draw(g);
        board.width = this.getWidth();
        board.height = this.getHeight();
        this.paintComponents(g);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon("field.jpg").getImage(), this.getWidth() , this.getHeight() , this);

        
    }

    public void draw(Graphics g) {

        for (int i = 0; i < this.getWidth(); i += 50) {
            for (int j = 30; j < this.getHeight(); j += 50) {
                if (i == snake.headx && j == snake.heady) {
                    g.drawImage(head, i, j, this);
                }
               else if (i == board.fruitx && j == board.fruity) {
                    g.drawImage(new ImageIcon("fruit.png").getImage(), i, j, this);

                }

                for (int k = 0; k < snake.tail; k++) {
                    if (i == snake.tailxx[k] && j == snake.tailyy[k]) {
                        g.drawImage(body, i, j, this);

                    }
                }
            }
        }
    }

    public void abend() {
        if (snake.headx == board.fruitx && snake.heady == board.fruity) {
            snake.tailxx[snake.tail] = snake.headx;
            snake.tailyy[snake.tail] = snake.heady;

            snake.tail++;
            board.generateFruite();
        }
        for (int i = snake.tail; i >= 0; i--) {
            if (i == 0) {
                snake.tailxx[i] = snake.headx;
                snake.tailyy[i] = snake.heady;
            } else {
                snake.tailxx[i] = snake.tailxx[i - 1];
                snake.tailyy[i] = snake.tailyy[i - 1];
            }
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    public void move(char ch) {
        if (ch == 's') {

            snake.heady += 50;
            head = headdown ; 
        }
        if (ch == 'w') {
            snake.heady -= 50;
            head = headtop ;
        }
        if (ch == 'd') {
            snake.headx += 50;
            head = headright ; 
        }
        if (ch == 'a') {
            snake.headx -= 50;
            head = headleft ; 
        }
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 's') {

            dir = e.getKeyChar();

        }
        if (e.getKeyChar() == 'w') {
            dir = e.getKeyChar();
        }
        if (e.getKeyChar() == 'd') {
            dir = e.getKeyChar();
        }
        if (e.getKeyChar() == 'a') {
            dir = e.getKeyChar();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public void check(){
        if(snake.headx >= this.getWidth() || snake.headx <= -50 || snake.heady <= 0 || snake.heady >= this.getHeight()){
            lose = true ;
        }
        for (int i = 0 ; i < snake.tail ; i ++ ){
            if (snake.headx == snake.tailxx[i] && snake.heady == snake.tailyy[i]){
                lose  = true ;
            }
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
