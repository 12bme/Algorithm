/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

/**
 *
 * @author jiseonoh
 */
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
public class FrogJmpOOP {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        try {
            Frog frog = new Frog(X, Y, D);
            if(!frog.isValid()) throw new Exception("input value error");
            
            while(true) { if(frog.jump()) break; }
        
            return frog.getCurrentJumpCount();
        } catch (Exception e) {
            return 0;
        }
    }
}

class Frog {
    private int currentPosition;
    private int targetPosition;
    private int distance;
    private int jump = 0;
    
    public Frog(int currentPosition, int targetPosition, int distance) {
        this.currentPosition = currentPosition;
        this.targetPosition = targetPosition;
        this.distance = distance;
    }
    
    public boolean isValid() {
        return (this.targetPosition > 0 && this.distance > 0);
    }
    
    public boolean jump() {
        this.jump++;
        currentPosition += distance;
        return currentPosition >= targetPosition;
    }

    public int getCurrentJumpCount() {
        return this.jump;
    }   
}
