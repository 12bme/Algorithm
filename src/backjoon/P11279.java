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
public class P11279 {
    static class Compare implements Comparator<Integer> {
        public int compare(Integer one, Integer two) {
            return two.compareTo(one);
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Compare cmp = new Compare();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(1, cmp);
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            if (x == 0) {
                if(x == 0) {
                    if(q.isEmpty()) {
                        System.out.println(0);
                    } else {
                        System.out.println(q.poll());
                    }
                }
            } else {
                q.offer(x);
            }
        }
    }
}
