package com.mycompany.snakegame;

import javax.swing.JOptionPane;

public class SnakeGame {
    public static void rungame(){
        Game g = new Game();
        g.setVisible(true);
        while (!g.lose) {

            g.abend();
            g.move(g.dir);
            g.check();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
            }
        }
        if(g.lose){
          g.lose =   JOptionPane.showConfirmDialog( null , "would you like to replay ? ") == 1 ? false : true ;
        }
        if (g.lose){
            g.dispose();
            rungame();
        }
        else {
            System.exit(0);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        rungame();
    }
}
