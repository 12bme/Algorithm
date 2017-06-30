/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.sort;

/**
 *
 * @author jiseonoh
 */
public class FibbonacciTuning {
    private int[] memoization;
    
    public int fibonacci(int i) {
        if(i == 0) return 0;
        if(i == 1) return 1;
        if(memoization[i] != 0) return memoization[i]; //캐시된 결과 반환
        memoization[i] = fibonacci(i-1) + fibonacci(i-2); //계산 결과 캐시
        return memoization[i];
    }
    
    public int solution(int input) {
        memoization = new int[input];
        return fibonacci(input);
    }
}
