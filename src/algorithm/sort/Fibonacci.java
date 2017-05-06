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
class Fibonacci {
    public static void main(String[] agrs) {
        int input = 8; // 8개 출력
        for (int i = 1; i <= input; i++) {
            System.out.println(fibo(i));
        }
    }

    public static int fibo(int n) {
	if (n <= 1) return n;
        else return fibo(n-2) + fibo(n-1);
    }
}
