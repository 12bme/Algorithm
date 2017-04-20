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
public class CyclicRotation {
    public static void main(String[] args) {
        int[] inputArray = {3, 8, 9, 7, 6};
        solution(inputArray, 3);
    }
    public static int[] solution(int[] A, int K) {
        int[] resultArray = new int[A.length];
        int index = 0;
        K = K%(A.length);
        System.out.println("K:" + K);
        for(int i = K; i < A.length; i++) {
            System.out.println(index + ", " + i);
            resultArray[index++] = A[i];
        }
        for(int i = 0; i < K; i++) {
            System.out.println(index + ", " + i);
            resultArray[index++] = A[i];
        }
        return resultArray;
    }
}
