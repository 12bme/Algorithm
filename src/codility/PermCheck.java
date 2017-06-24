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
public class PermCheck {
    public static void main(String[] args) {
        int[] myIntArray = {1,2,4};
        PermCheckSolution mySolution = new PermCheckSolution();
        try {
            System.out.println(mySolution.solve(myIntArray));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class PermCheckSolution {
    public int solve(int[] A) {
        int length = A.length;
        int lengthSum = ((1+length)*length)/2;
        int arraySum = arraySum(A);
        
        return (lengthSum - arraySum == 0 ? 1 : 0);
    }
    
    private int arraySum(int[] A) {
        int index = 0, sum = 0;
        for(; index < A.length; index++) {
            sum += A[index];
        }
        return sum;
    }
}
