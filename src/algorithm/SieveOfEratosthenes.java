/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author jiseonoh
 */
public class SieveOfEratosthenes {
    public boolean[] solution(int max) {
        boolean[] flags = new boolean[max+1];
        int count = 0;
        
        // 0번째와 1번째를 제외한 모든 원소의 값을 true로 초기화
        if(max == 0) flags[0] = false;
        if(max >= 1) flags[1] = false;
        
        for(int i=0; i <= max; i++) flags[i] = true;
        
        int prime = 2;
        
        while(prime <= max) {
            /* 소수의 정수배인 수들을 솎아냄 */
            crossOff(flags, prime);
            
            /* Find next value which is true. */
            prime = getNextPrime(flags, prime);
            
            if(prime >= flags.length) break;
        }
        
        return flags;
    }
    
    public void crossOff(boolean[] flags, int prime) {
        /*
        prime의 정수배인 수들을 솎아낸다.
        k < prime인 k에 대한 k*prime은
        앞서 실행된 루프에서 솎아졌을 것이므로
        prime * prime 부터 시작한다.
        */
        for(int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }
    
    public int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }
    
    // 개선의 여지는 남아있다. 한 가지 방법은 배열에 홀수만 저장하는 것이다.
    // 그러면 메모리 요구량을 반으로 줄일 수 있다.
}
