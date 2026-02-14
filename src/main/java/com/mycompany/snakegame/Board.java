
package com.mycompany.snakegame;
import java.util.Random ; 
public class Board {
    int width ; 
    int height ; 
    int fruitx ; 
    int fruity ; 
    Random r = new Random();
    public Board(){
        
    }
    public void generateFruite(){
        fruitx = r.nextInt(width/50)*50; 
        fruity = r.nextInt(height/50)*50 + 30 ; 
        System.out.println(fruitx + " " +  fruity );
    }
}
