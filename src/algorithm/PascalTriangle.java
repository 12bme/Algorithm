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
public class PascalTriangle {
    public PascalTriangle() {
        long time1, time2;
        int n = 30;

        time1 = System.currentTimeMillis();
        test1(n);
        time2 = System.currentTimeMillis();
        System.out.println("\nTest1:" + (time2 - time1) + " mili-sec elapse.");

        time1 = System.currentTimeMillis();
        test2(n);
        time2 = System.currentTimeMillis();
        System.out.println("\nTest2:" + (time2 - time2) + " mili-sec elapse.");
        
        time1 = System.currentTimeMillis();
        test3(n);
        time2 = System.currentTimeMillis();
        System.out.println("\nTest3:" + (time2 - time2) + " mili-sec elapse.");
    }
    
    private void test1(int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j <= i; j++) {
                System.out.print(triangleNum(i, j) + "");
            }
            System.out.print("");
        }
    }
    
    private void test2(int n) {
        int[][] cache = new int[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j <= i; j++) {
                System.out.print(triangleNumCache(i, j, cache) + "");
            }
            System.out.print("");
        }
    }

    private void test3(int n) {
        for (int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print(triangleNumTable(i, j) + " ");
            }
            System.out.print("");
        }
    }
    
    private static int triangleNum(int i, int j) {
        if(j==0 || i==j) return 1;
        return triangleNum(i-1, j-1) + triangleNum(i-1, j);
    }
    
    private static int triangleNumCache(int i, int j, int[][] cache) {
        if(j==0 || i==0) return 1;
        if(cache[i][j] != 0) return cache[i][j];
        
        cache[i][j] = triangleNum(i-1, j-1) + triangleNum(i-1, j);
        return cache[i][j];
    }
    
    private static int triangleNumTable(int r, int c) {
        int n = r + 1;
        int[][] table = new int[n][n];
        
        table[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || i == j) table[i][j] = 1;
                else table[i][j] = table[i-1][j-1] + table[i-1][j];
            }
        }
        return table[r][c];
    }
    
    public static void main(String[] args) {
        new PascalTriangle();
    }
}
