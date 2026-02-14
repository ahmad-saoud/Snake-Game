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
            Thread.sleep(g.ti);
        } catch (InterruptedException ex) {
            System.getLogger(Game.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
                
                g.repaint();
            
        }
        if(g.lose){
          g.abend();
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
