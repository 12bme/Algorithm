package codility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author jiseonoh
 */
public class CyclicRotation {
    public static void main(String[] args) {
        int[] inputArray = {3, 8, 9, 7, 6};
        Solution mySolution = new Solution();
        mySolution.solution(inputArray, 3);
    }
}

class Solution {
    public int[] solution(int[] A, int K) {
        // input Array => A, test case coding
        int length = A.length;
        
        if(length <= 1) return A;
        else {
            int rotationCount = K%length; // real rotation count
            if(rotationCount == 0) return A;
            Queue pre = new LinkedList();
            Queue post = new LinkedList();
            int gap = length - rotationCount;
            for(int index=0; index < length; index++) {
                if(gap == 0) pre.offer(A[index]);
                else {
                    gap--;
                    post.offer(A[index]);
                }
            }
            for(int index=0; index < length; index++) {
                if(pre.peek() != null) { A[index] = (int)pre.poll(); }
                else A[index] = (int)post.poll();
            }
            return A;
        }
    }
}
