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
public class MyTerm1 {
    public static void main (String[] args) {
        System.out.println(String.format("%02d:%02d", 12,3));
        System.out.println(MyTerm3Solution.POSSIBLE_TIME_FORMAT);
    }
}

class MyTerm3Solution {
    public static final String POSSIBLE_TIME_FORMAT = "NOT POSSIBLE";
    public int solve(int[] A) {
                // write your code in Java SE 8
        // output variable
        int result = -1;
        
        try {
            // 1. Exception
            Exception invalidInputException = new Exception("invalid Input Exception");
        
            if(null == A) throw invalidInputException;
            int length = A.length;
            if(0 == length || 100000 < length) throw invalidInputException;

            // 2. algorithm
            int index = 0;
            int[] checkSum = new int[length];
            for(index = length; index >= 0; index--) {
                // arraySum Check
                checkSum[index] += checkSum[index-1];
            }
        
            for(index=0; index < length-1; index++) {
                // compare Check
                if(A[index] == checkSum[index + 1]) { result = (index + 1); break; }
                A[index+1] += A[index];
            }
        
            // 3. output
            return result;
        } catch(Exception e) {
            return -1;
        }
    }
}
