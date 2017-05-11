/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backjoon;

import java.math.*;
import java.util.*;

/**
 *
 * @author jiseonoh
 */
public class P10826 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger[] d = new BigInteger[Math.max(n+1, 2)];
        d[0] = BigInteger.ZERO;
        d[1] = BigInteger.ONE;
        for (int i=2; i<=n; i++) {
            d[i] = d[i-1].add(d[i-2]);
        }
        System.out.println(d[n]);
    }
}
