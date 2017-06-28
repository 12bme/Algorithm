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
public class PrimeNaive {
    public boolean simpleSolution(int n) {
        if(n < 2) return false;
        for(int i=2; i<n; i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
    /*
    sqrt까지만 검사해보면 충분한데, n을 a로 나눌 수 있다면 n에 대한 a의 보수 b(a*b=n)가 반드시 존재하기 때문이다.
    만일 a>sqrt이면 b<sqrt이다(sqrt*sqrt=n이니까). 그러므로 n이 소수인지를 알아보기 위해 a까지 검사할 필요는 없다.
    b를 통해 이미 검사했기 때문이다.
    
    물론 실제로는 n이 다른 소수로 나뉘는지만 검사하면 된다. 그래서 에라토스테네스 체가 필요하다.
    */
    public boolean slightlyBetterSolution(int n) {
        if(n < 2) return false;
        int sqrt = (int)Math.sqrt(n);
        for(int i = 2; i <= sqrt; i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
}
