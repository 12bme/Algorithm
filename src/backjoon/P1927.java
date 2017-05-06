/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backjoon;
import java.util.*;

/**
 *
 * @author jiseonoh
 */
public class P1927 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            if( x == 0 ) {
                if(q.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(q.poll());
                }
            } else {
                q.offer(x);
            }
        }
    }
}
