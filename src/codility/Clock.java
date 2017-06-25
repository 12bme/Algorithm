/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

import java.util.*;
/**
 *
 * @author jiseonoh
 */
public class Clock {
    
    public static void main(String[] args) {
        // write your code in Java SE 8
        /*
        ClockSolution inputClock = new ClockSolution(0, 2, 0, 4);
        System.out.println(inputClock.toString());
        
        String[] time = "12:30".split(":");
        System.out.println(Integer.parseInt(time[0]));
        */
        int[] i = {1,3,5,4};
        Arrays.sort(i);
    }

}

class ClockSolution {
    private int hours;
    private int minutes;
    private boolean valid = true;
    private static final String POSSIBLE_TIME_FORMAT = "NOT POSSIBLE";
    
    public ClockSolution(int hoursFirst, int hoursSecond, int minuteFirst, int minuteSecond) {
        if( (0 > hoursFirst || 10 < hoursSecond) ||
            (0 > minuteFirst || 10 < minuteSecond) ) {
            valid = false;
            return;
        }
        this.hours = (hoursFirst * 10) + hoursSecond;
        this.minutes = (minuteFirst * 10) + minuteSecond;
    }
    
    public boolean isValid() {
        if((!valid) || (24 < hours || 0 > hours) || (59 < minutes || 0 > minutes)) return false;        
        return true; 
    }
    
    public String toString() {
        if(this.isValid()) return String.format("%02d:%02d", this.hours, this.minutes);
        return this.POSSIBLE_TIME_FORMAT;
    }
}
