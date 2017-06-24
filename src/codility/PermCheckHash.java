/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

import java.util.HashMap;

/**
 *
 * @author jiseonoh
 */
public class PermCheckHash {
    public static void main(String[] args) {
        int[] myIntArray = {1,2,3,4};
        PermCheckHashSolution mySolution = new PermCheckHashSolution();
        try {
            long startTime = System.currentTimeMillis();
            for(int i = 0; i < 1000; i++){
               mySolution.solve(myIntArray);
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("Total elapsed time = " + elapsedTime);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class PermCheckHashSolution {
    public int solve(int[] A) {
        if(null == A) return 0;
        int result = 1;
        HashMap<Integer, Boolean> inputCheck = new HashMap<Integer, Boolean>();
        int size = A.length;

        for(int i = 1; i < size + 1; i++) {
            inputCheck.put(i, false);
        }
        
        for(int i=0; i < size; i++) {
            if(null == inputCheck.get(A[i])) {result = 0; break;}
            inputCheck.remove(A[i]);
        }

        return result;
    }
}
