/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 *
 * @author jiseonoh
 */
class Factorial {
    public static void main(String[] args) {
           int input = 4; // 4!
           System.out.println(fact(input));
    }

    public static int fact(int n) {
        if (n <= 1) return n;
        else return fact(n-1) * n;
    }
}
