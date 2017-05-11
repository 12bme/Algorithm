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
 * 
 * 수 정렬하기
 * 문제) N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램
 * 
 * 입력) 
 * 첫째 줄에 수의 개수 N(1 <= N <= 1,000)이 주어집니다. 둘째 줄부터 N개의 줄에는 숫자가 주어집니다.
 * 이 수는 절대값이 1,000보다 작거나 같은 정수입니다. 수는 중복되지 않습니다.
 * 
 * 출력)
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력합니다.
 * 
 */
public class P2750 {
    // soloution 1
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i=0; i<n; i++) {
            int temp = sc.nextInt();
            a.add(temp);
        }
        Collections.sort(a);
        for (int x : a) {
            System.out.println(x);
        }
    }
    
    //solution 2
    public static void solution2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for (int x : a) {
            System.out.println(x);
        }
    }
}
