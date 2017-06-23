package codility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jiseonoh
 */
public class PermMissingElement {
    public static void main(String[] args) {
        int[] myIntArray = {1,2,4};
        PermMissingElementSolution mySolution = new PermMissingElementSolution();
        try {
            System.out.println(mySolution.solution(myIntArray));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class PermMissingElementSolution {
    public int solution(int[] A) throws Exception {
        Exception inputException = new Exception("invalid input eror");
        Exception resultException = new Exception("invalid result error");
        // 예외 처리
        if(null == A || A.length == 0) throw inputException;
        if(A.length == 1 && A[0] != 1) throw inputException;
        
        int arraySize = A.length;
        int result = 0, index = 1, targetSum = 0, arraySum = 0;
        for(index = 1; index < arraySize+2; index++) targetSum += index;
        for(index = 0; index < arraySize; index++) arraySum += A[index];
        result = targetSum - arraySum;

        if(result < 1) throw resultException;
        
        return result;
    }
}

/*
class Solution {
    public int solution(int[] A) {
        // 예외 처리
        try {
            return this.solve(A);
        } catch(Exception e) {
            return 0;
        }
    }
    
    public int solve(int[] A) throws Exception{
        Exception inputException = new Exception("invalid input eror");
        
        if(null == A || A.length == 0) throw inputException;
        if(A.length == 1 && A[0] != 1) throw inputException;
        
        int arraySize = A.length;
        int result = 0, index = 1, targetSum = 0, arraySum = 0;
        for(index = 1; index < arraySize+2; index++) targetSum += index;
        for(index = 0; index < arraySize; index++) arraySum += A[index];
        result = targetSum - arraySum;

        if(result < 1) throw new Exception("invalid result error");;
        
        return result;
    }
}
*/